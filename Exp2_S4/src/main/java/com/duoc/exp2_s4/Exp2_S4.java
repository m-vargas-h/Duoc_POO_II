package com.duoc.exp2_s4;

/**
 *
 * @author mvarg
 */

import com.duoc.exp2_s4.view.MenuPrincipal;

/**
 * Clase principal del sistema de gestión de inventario.
 * Inicia la ejecución del menú interactivo en consola.
 */
public class Exp2_S4 {
    /**
     * Método main que lanza la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();
    }
}