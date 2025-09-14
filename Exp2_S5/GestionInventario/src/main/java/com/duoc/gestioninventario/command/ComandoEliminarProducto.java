/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.command;

import com.duoc.gestioninventario.controller.InventarioController;
import com.duoc.gestioninventario.util.InputManager;

/**
 *
 * @author mvarg
 */

/**
 * Comando para agregar un nuevo producto al inventario.
 */
public class ComandoEliminarProducto implements Command {
    private final InventarioController controller;
    private final InputManager input;

    public ComandoEliminarProducto(InventarioController controller, InputManager input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void ejecutar() {
        String codigo = input.leerTexto("Código del producto a eliminar: ");
        boolean eliminado = controller.eliminarProducto(codigo);
        System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
    }
}
