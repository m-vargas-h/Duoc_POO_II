package com.duoc.exp2_s4.view;

import com.duoc.exp2_s4.controller.Inventario;
import com.duoc.exp2_s4.model.Producto;
import com.duoc.exp2_s4.util.InputManager;

import java.util.Map;

/**
 * Clase encargada de mostrar el menú principal en consola
 * y gestionar la interacción con el usuario.
 */
public class MenuPrincipal {
    private final Inventario inventario;
    private final InputManager input;

    /**
     * Constructor que inicializa el menú con un inventario vacío y el gestor de entrada.
     */
    public MenuPrincipal() {
        inventario = new Inventario();
        input = new InputManager();
    }

    /**
     * Muestra el menú principal y gestiona las opciones seleccionadas por el usuario.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n----- MENÚ DE INVENTARIO -----");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Salir");
            opcion = input.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> eliminarProducto();
                case 3 -> buscarProducto();
                case 4 -> listarProductos();
                case 5 -> actualizarProducto();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    /**
     * Solicita los datos de un nuevo producto y lo agrega al inventario.
     */
    private void agregarProducto() {
        String codigo = input.leerTexto("Código: ");
        String nombre = input.leerTexto("Nombre: ");
        String descripcion = input.leerTexto("Descripción: ");
        double precio = input.leerDecimal("Precio: ");
        int cantidad = input.leerEntero("Cantidad: ");

        Producto producto = new Producto(codigo, nombre, descripcion, precio, cantidad);
        boolean agregado = inventario.agregarProducto(producto);
        System.out.println(agregado ? "Producto agregado correctamente." : "Ya existe un producto con ese código.");
    }

    /**
     * Solicita el código de un producto y lo elimina del inventario si existe.
     */
    private void eliminarProducto() {
        String codigo = input.leerTexto("Código del producto a eliminar: ");
        boolean eliminado = inventario.eliminarProducto(codigo);
        System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
    }

    /**
     * Busca un producto por su código e imprime su información detallada.
     */
    private void buscarProducto() {
        String codigo = input.leerTexto("Código del producto a buscar: ");
        Producto producto = inventario.buscarPorCodigo(codigo);
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(producto.getDescripcionDetallada());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Lista todos los productos registrados en el inventario.
     */
    private void listarProductos() {
        Map<String, Producto> productos = inventario.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n----- LISTADO DE PRODUCTOS -----");
            for (Producto p : productos.values()) {
                System.out.println(p.getDescripcionDetallada());
            }
        }
    }

    /**
     * Solicita los nuevos datos de un producto existente y actualiza su información.
     */
    private void actualizarProducto() {
        String codigo = input.leerTexto("Código del producto a actualizar: ");
        Producto producto = inventario.buscarPorCodigo(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Ingrese los nuevos datos del producto:");
        String nuevoNombre = input.leerTexto("Nuevo nombre: ");
        String nuevaDescripcion = input.leerTexto("Nueva descripción: ");
        double nuevoPrecio = input.leerDecimal("Nuevo precio: ");
        int nuevaCantidad = input.leerEntero("Nueva cantidad: ");

        boolean actualizado = inventario.actualizarProducto(codigo, nuevoNombre, nuevaDescripcion, nuevoPrecio, nuevaCantidad);
        System.out.println(actualizado ? "Producto actualizado correctamente." : "No se pudo actualizar el producto.");
    }
}