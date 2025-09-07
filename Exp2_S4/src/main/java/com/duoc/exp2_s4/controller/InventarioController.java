package com.duoc.exp2_s4.controller;

import com.duoc.exp2_s4.model.Producto;

import java.util.Map;

/**
 * Controlador que intermedia entre la vista y el modelo Inventario.
 */
public class InventarioController {

    private final Inventario inventario;

    /**
     * Constructor que inicializa el controlador con un inventario dado.
     *
     * @param inventario Inventario a gestionar
     */
    public InventarioController(Inventario inventario) {
        this.inventario = inventario;
    }

    public boolean registrarProducto(Producto productoDecorado) {
        return inventario.agregarProducto(productoDecorado);
    }

    /**
     * Elimina un producto del inventario por su código.
     *
     * @param codigo Código del producto a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarProducto(String codigo) {
        return inventario.eliminarProducto(codigo);
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo Código del producto a buscar
     * @return Producto si se encuentra, null si no existe
     */
    public Producto buscarProducto(String codigo) {
        return inventario.buscarPorCodigo(codigo);
    }

    /**
     * Busca productos que contengan el texto dado en su nombre o descripción.
     *
     * @param texto Texto a buscar
     * @return Mapa de productos que coinciden con la búsqueda
     */
    public Map<String, Producto> buscarPorTexto(String texto) {
        return inventario.buscarPorTexto(texto);
    }

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param codigo Código del producto a actualizar
     * @param nuevoNombre Nuevo nombre del producto
     * @param nuevaDescripcion Nueva descripción del producto
     * @param nuevoPrecio Nuevo precio del producto
     * @param nuevaCantidad Nueva cantidad disponible en inventario
     * @return true si se actualizó correctamente, false si no se encontró el producto
     */
    public boolean actualizarProducto(String codigo, String nuevoNombre, String nuevaDescripcion,
                                      double nuevoPrecio, int nuevaCantidad) {
        return inventario.actualizarProducto(codigo, nuevoNombre, nuevaDescripcion, nuevoPrecio, nuevaCantidad);
    }

    /**
     * Reemplaza un producto existente por uno nuevo.
     *
     * @param codigo Código del producto a reemplazar
     * @param nuevoProducto Nuevo producto que reemplaza al existente
     */
    public void reemplazarProducto(String codigo, Producto nuevoProducto) {
        inventario.eliminarProducto(codigo);
        inventario.agregarProducto(nuevoProducto);
    }

    /**
     * Lista todos los productos registrados en el inventario.
     *
     * @return Mapa con todos los productos
     */
    public Map<String, Producto> listarProductos() {
        return inventario.listarProductos();
    }

    /**
     * Guarda el inventario actual en un archivo CSV.
     */
    public void guardarInventario() {
        inventario.guardar();
    }

    /**
     * Carga el inventario desde un archivo CSV.
     */
    public void cargarInventario() {
        inventario.cargar();
    }
    
    public Inventario getInventario() {
        return inventario;
    }
}