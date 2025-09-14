/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.command;

import com.duoc.gestioninventario.controller.InventarioController;
import com.duoc.gestioninventario.model.EtiquetaProducto;
import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.model.ProductoConDescuento;
import com.duoc.gestioninventario.model.ProductoConEtiqueta;
import com.duoc.gestioninventario.util.CodigoProductoGenerator;
import com.duoc.gestioninventario.util.InputManager;

/**
 *
 * @author mvarg
 */

/**
 * Comando para agregar un nuevo producto al inventario.
 */
public class ComandoAgregarProducto implements Command {
    private final InventarioController controller;
    private final InputManager input;

    public ComandoAgregarProducto(InventarioController controller, InputManager input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void ejecutar() {
        String codigo = CodigoProductoGenerator.generarCodigo(controller.getInventario());
        System.out.println("Código asignado automáticamente: " + codigo);
        String nombre = input.leerTexto("Nombre: ");
        String descripcion = input.leerTexto("Descripción: ");
        double precio = input.leerDecimal("Precio: ");
        int cantidad = input.leerEntero("Cantidad: ");

        EtiquetaProducto.mostrarOpciones();
        int seleccionEtiqueta = input.leerEntero("Seleccione una etiqueta: ");
        EtiquetaProducto etiqueta = EtiquetaProducto.obtenerPorIndice(seleccionEtiqueta);

        double descuento = input.leerDecimal("Porcentaje de descuento (0 si no aplica): ");

        Producto producto = new Producto(codigo, nombre, descripcion, precio, cantidad);
        if (etiqueta != EtiquetaProducto.SIN_ETIQUETA) {
            producto = new ProductoConEtiqueta(producto, etiqueta.name().replace("_", " "));
        }
        if (descuento > 0) {
            producto = new ProductoConDescuento(producto, descuento);
        }

        boolean ok = controller.registrarProducto(producto);
        System.out.println(ok ? "Producto agregado correctamente." : "Ya existe un producto con ese código.");
    }
}
