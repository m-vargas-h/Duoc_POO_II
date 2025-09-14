/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.command;

import com.duoc.gestioninventario.controller.InventarioController;
import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.util.InputManager;
import java.util.Map;

/**
 *
 * @author mvarg
 */

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
