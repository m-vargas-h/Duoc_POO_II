package com.duoc.exp2_s4.command;

import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.model.*;
import com.duoc.exp2_s4.util.InputManager;

public class ComandoAgregarProducto implements Command {
    private final InventarioController controller;
    private final InputManager input;

    public ComandoAgregarProducto(InventarioController controller, InputManager input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void ejecutar() {
        String codigo = input.leerTexto("Código: ");
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