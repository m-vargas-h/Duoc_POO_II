/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.command;

import com.duoc.gestioninventario.controller.InventarioController;
import com.duoc.gestioninventario.model.*;
import com.duoc.gestioninventario.util.InputManager;
import com.duoc.gestioninventario.util.ProductoUtils;

/**
 *
 * @author mvarg
 */

/**
 * Comando que permite modificar atributos específicos de un producto.
 */
public class ComandoActualizarProducto implements Command {
    private final InventarioController controller;
    private final InputManager input;

    public ComandoActualizarProducto(InventarioController controller, InputManager input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void ejecutar() {
        String codigo = input.leerTexto("Código del producto a actualizar: ");
        Producto producto = controller.buscarProducto(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione el atributo a modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Descripción");
            System.out.println("3. Precio");
            System.out.println("4. Cantidad");
            System.out.println("5. Etiqueta");
            System.out.println("6. Descuento");
            System.out.println("7. Finalizar");
            int opcion = input.leerEntero("Opción: ");

            switch (opcion) {
                case 1 -> {
                    String nuevoNombre = input.leerTexto("Nuevo nombre: ");
                    boolean ok = controller.actualizarNombre(codigo, nuevoNombre);
                    if (!ok) System.out.println("No se pudo actualizar el nombre.");
                }

                case 2 -> {
                    String nuevaDescripcion = input.leerTexto("Nueva descripción: ");
                    boolean ok = controller.actualizarDescripcion(codigo, nuevaDescripcion);
                    if (!ok) System.out.println("No se pudo actualizar la descripción.");
                }

                case 3 -> {
                    double nuevoPrecio = input.leerDecimal("Nuevo precio: ");
                    boolean ok = controller.actualizarPrecio(codigo, nuevoPrecio);
                    if (!ok) System.out.println("No se pudo actualizar el precio.");
                }

                case 4 -> {
                    int nuevaCantidad = input.leerEntero("Nueva cantidad: ");
                    boolean ok = controller.actualizarStock(codigo, nuevaCantidad);
                    if (!ok) System.out.println("No se pudo actualizar el stock.");
                }

                case 5 -> {
                    EtiquetaProducto.mostrarOpciones();
                    int seleccion = input.leerEntero("Seleccione nueva etiqueta: ");
                    EtiquetaProducto etiqueta = EtiquetaProducto.obtenerPorIndice(seleccion);

                    Producto base = ProductoUtils.obtenerProductoBase(producto);

                    if (etiqueta != EtiquetaProducto.SIN_ETIQUETA) {
                        producto = new ProductoConEtiqueta(base, etiqueta.name().replace("_", " "));
                    } else {
                        producto = base; // sin etiqueta
                    }
                }

                case 6 -> {
                    double descuento = input.leerDecimal("Porcentaje de descuento (0 si no aplica): ");

                    Producto base = ProductoUtils.obtenerProductoBase(producto);

                    if (descuento > 0) {
                        producto = new ProductoConDescuento(base, descuento);
                    } else {
                        producto = base; // sin descuento
                    }
                }

                case 7 -> continuar = false;
                
                default -> System.out.println("Opción inválida.");
            }
        }

        controller.reemplazarProducto(codigo, producto);
        System.out.println("Producto actualizado correctamente.");
    }
}
