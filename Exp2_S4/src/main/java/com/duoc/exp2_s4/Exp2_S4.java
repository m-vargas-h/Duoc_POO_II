package com.duoc.exp2_s4;

import com.duoc.exp2_s4.controller.Inventario;
import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.view.MenuPrincipal;

/**
 * Punto de entrada del sistema.
 */
public class Exp2_S4 {
    public static void main(String[] args) {
        
        Inventario inventario = Inventario.getInstancia(); // Obtener la instancia singleton del inventario
        inventario.cargar();

        InventarioController controller = new InventarioController(inventario);
        MenuPrincipal menu = new MenuPrincipal(controller);
        menu.mostrarMenu();

    }
}