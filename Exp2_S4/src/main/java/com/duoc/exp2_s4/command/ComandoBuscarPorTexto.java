package com.duoc.exp2_s4.command;

import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.model.Producto;
import com.duoc.exp2_s4.util.InputManager;

import java.util.Map;

/**
 * Comando que busca productos por nombre o descripción.
 */
public class ComandoBuscarPorTexto implements Command {
    private final InventarioController controller;
    private final InputManager input;

    public ComandoBuscarPorTexto(InventarioController controller, InputManager input) {
        this.controller = controller;
        this.input = input;
    }

    @Override
    public void ejecutar() {
        String texto = input.leerTexto("Ingrese texto a buscar (nombre o descripción): ");
        Map<String, Producto> resultados = controller.buscarPorTexto(texto);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            resultados.values().forEach(p -> System.out.println(p.getDescripcionDetallada()));
        }
    }
}