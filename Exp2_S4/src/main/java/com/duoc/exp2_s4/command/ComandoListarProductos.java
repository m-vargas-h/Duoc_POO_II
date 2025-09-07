package com.duoc.exp2_s4.command;

import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.model.Producto;

/**
 * Comando que lista todos los productos disponibles en el inventario.
 */
public class ComandoListarProductos implements Command {
    private final InventarioController controller;

    public ComandoListarProductos(InventarioController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        var productos = controller.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n=== LISTADO DE PRODUCTOS ===");
            productos.values().forEach(p -> System.out.println(p.getDescripcionDetallada()));
        }
    }
}