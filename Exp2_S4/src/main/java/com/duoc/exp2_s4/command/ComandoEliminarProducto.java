package com.duoc.exp2_s4.command;

import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.util.InputManager;

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