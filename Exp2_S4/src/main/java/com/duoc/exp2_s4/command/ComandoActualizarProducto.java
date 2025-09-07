package com.duoc.exp2_s4.command;

import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.model.*;
import com.duoc.exp2_s4.util.InputManager;

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
                case 1 -> producto.setNombre(input.leerTexto("Nuevo nombre: "));
                case 2 -> producto.setDescripcion(input.leerTexto("Nueva descripción: "));
                case 3 -> producto.setPrecio(input.leerDecimal("Nuevo precio: "));
                case 4 -> producto.setCantidad(input.leerEntero("Nueva cantidad: "));
                case 5 -> {
                    EtiquetaProducto.mostrarOpciones();
                    int seleccion = input.leerEntero("Seleccione nueva etiqueta: ");
                    EtiquetaProducto etiqueta = EtiquetaProducto.obtenerPorIndice(seleccion);
                    if (etiqueta != EtiquetaProducto.SIN_ETIQUETA) {
                        producto = new ProductoConEtiqueta(producto, etiqueta.name().replace("_", " "));
                    }
                }
                case 6 -> {
                    double descuento = input.leerDecimal("Porcentaje de descuento (0 si no aplica): ");
                    if (descuento > 0) {
                        producto = new ProductoConDescuento(producto, descuento);
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