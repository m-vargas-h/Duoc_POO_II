/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.command;

import com.duoc.gestioninventario.controller.InventarioController;
import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.util.InputManager;

/**
 *
 * @author mvarg
 */

/**
 * Comando para buscar un producto en el inventario por su código.
 */
public class ComandoBuscarProducto implements Command {
    private final InventarioController controller;
    private final InputManager input;

    public ComandoBuscarProducto(InventarioController controller, InputManager input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void ejecutar() {
        String codigo = input.leerTexto("Código del producto a buscar: ");
        Producto producto = controller.buscarProducto(codigo);
        System.out.println(producto != null ? producto.getDescripcionDetallada() : "Producto no encontrado.");
    }
}
