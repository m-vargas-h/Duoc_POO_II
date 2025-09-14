/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.command;

import com.duoc.gestioninventario.controller.InventarioController;

/**
 *
 * @author mvarg
 */

/**
 * Comando que lista todos los productos disponibles en el inventario.
 */
public class ComandoListarProducto implements Command {
    private final InventarioController controller;

    public ComandoListarProducto(InventarioController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        var productos = controller.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n----- LISTADO DE PRODUCTOS -----");
            productos.values().forEach(p -> System.out.println(p.getDescripcionDetallada()));
        }
    }
}
