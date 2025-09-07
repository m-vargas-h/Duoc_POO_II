package com.duoc.exp2_s4.view;

import com.duoc.exp2_s4.command.*;
import com.duoc.exp2_s4.controller.InventarioController;
import com.duoc.exp2_s4.util.InputManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Vista principal del sistema. Muestra el menú y ejecuta comandos según la opción seleccionada.
 */
public class MenuPrincipal {
    private final InventarioController controller;
    private final InputManager input;
    private final Map<Integer, Command> comandos;

    /**
     * Constructor que inicializa el menú con sus comandos.
     *
     * @param controller Controlador del inventario
     */
    public MenuPrincipal(InventarioController controller) {
        this.controller = controller;
        this.input = new InputManager();
        this.comandos = new HashMap<>();
        inicializarComandos();
    }

    /**
     * Registra los comandos disponibles en el menú.
     */
    private void inicializarComandos() {
        comandos.put(1, new ComandoAgregarProducto(controller, input));
        comandos.put(2, new ComandoEliminarProducto(controller, input));
        comandos.put(3, new ComandoBuscarProducto(controller, input));
        comandos.put(4, new ComandoBuscarPorTexto(controller, input));
        comandos.put(5, new ComandoListarProductos(controller));
        comandos.put(6, new ComandoActualizarProducto(controller, input));
    }

    /**
     * Muestra el menú principal y ejecuta el comando correspondiente.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n----- MENÚ DE INVENTARIO -----");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Buscar producto por texto");
            System.out.println("5. Listar productos");
            System.out.println("6. Actualizar producto");
            System.out.println("7. Salir");
            opcion = input.leerEntero("Seleccione una opción: ");

            if (opcion == 7) {
                controller.guardarInventario();
                System.out.println("Inventario guardado. Saliendo del sistema...");
                break;
            }

            Command comando = comandos.get(opcion);
            if (comando != null) {
                comando.ejecutar();
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (true);
    }
}