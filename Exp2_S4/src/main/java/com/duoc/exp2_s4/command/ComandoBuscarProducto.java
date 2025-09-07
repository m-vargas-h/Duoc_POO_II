package com.duoc.exp2_s4.command;

import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.model.Producto;
import com.duoc.exp2_s4.util.InputManager;

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