/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.duoc.gestioninventario;

import com.duoc.gestioninventario.controller.Inventario;
import com.duoc.gestioninventario.controller.InventarioController;
import com.duoc.gestioninventario.view.MenuPrincipal;

/**
 *
 * @author mvarg
 */
public class GestionInventario {

    public static void main(String[] args) {
        
        Inventario inventario = Inventario.getInstancia(); // Obtener la instancia singleton del inventario
        inventario.cargar();

        InventarioController controller = new InventarioController(inventario);
        MenuPrincipal menu = new MenuPrincipal(controller);
        menu.mostrarMenu();

    }
}
