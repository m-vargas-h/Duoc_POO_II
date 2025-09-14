/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.controller;

import java.util.Map;

import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.model.ProductoConDescuento;
import com.duoc.gestioninventario.model.ProductoConEtiqueta;
import com.duoc.gestioninventario.util.ProductoUtils;

/**
 *
 * @author mvarg
 */

/**
 * Controlador que intermedia entre la vista y el modelo Inventario.
 */
public class InventarioController {

    private final Inventario inventario;

    /**
     * Reaplica los decoradores de un producto original a una nueva instancia base.
     *
     * @param original Producto original con decoradores
     * @param base Nueva instancia base del producto
     * @return Producto con los mismos decoradores que el original
     */
    private Producto reaplicarDecoradores(Producto original, Producto base) {
        Producto decorado = base;

        if (original instanceof ProductoConEtiqueta etiquetaDecorada) {
            decorado = new ProductoConEtiqueta(decorado, etiquetaDecorada.getEtiqueta());
        }
        if (original instanceof ProductoConDescuento descuentoDecorado) {
            decorado = new ProductoConDescuento(decorado, descuentoDecorado.getPorcentajeDescuento());
        }

        return decorado;
    }

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
     * Actualiza solo el stock (cantidad) de un producto.
     *
     * @param codigo Código del producto a actualizar
     * @param nuevaCantidad Nueva cantidad disponible en inventario
     * @return true si se actualizó correctamente, false si no se encontró el producto
     */
    public boolean actualizarStock(String codigo, int nuevaCantidad) {
        Producto producto = buscarProducto(codigo);
        if (producto == null) return false;

        Producto base = ProductoUtils.obtenerProductoBase(producto);
        base.setCantidad(nuevaCantidad);

        Producto actualizado = reaplicarDecoradores(producto, base);
        reemplazarProducto(codigo, actualizado);
        return true;
    }

    /**
     * Actualiza solo el nombre de un producto.
     *
     * @param codigo Código del producto a actualizar
     * @param nuevoNombre Nuevo nombre del producto
     * @return true si se actualizó correctamente, false si no se encontró el producto
     */
    public boolean actualizarNombre(String codigo, String nuevoNombre) {
        Producto producto = buscarProducto(codigo);
        if (producto == null) return false;

        Producto base = ProductoUtils.obtenerProductoBase(producto);
        base.setNombre(nuevoNombre);

        Producto actualizado = reaplicarDecoradores(producto, base);
        reemplazarProducto(codigo, actualizado);
        return true;
    }

    /**
     * Actualiza solo la descripción de un producto.
     *
     * @param codigo Código del producto a actualizar
     * @param nuevaDescripcion Nueva descripción del producto
     * @return true si se actualizó correctamente, false si no se encontró el producto
     */
    public boolean actualizarDescripcion(String codigo, String nuevaDescripcion) {
        Producto producto = buscarProducto(codigo);
        if (producto == null) return false;

        Producto base = ProductoUtils.obtenerProductoBase(producto);
        base.setDescripcion(nuevaDescripcion);

        Producto actualizado = reaplicarDecoradores(producto, base);
        reemplazarProducto(codigo, actualizado);
        return true;
    }

    /**
     * Actualiza solo el precio de un producto.
     *
     * @param codigo Código del producto a actualizar
     * @param nuevoPrecio Nuevo precio del producto
     * @return true si se actualizó correctamente, false si no se encontró el producto
     */
    public boolean actualizarPrecio(String codigo, double nuevoPrecio) {
        Producto producto = buscarProducto(codigo);
        if (producto == null) return false;

        Producto base = ProductoUtils.obtenerProductoBase(producto);
        base.setPrecio(nuevoPrecio);

        Producto actualizado = reaplicarDecoradores(producto, base);
        reemplazarProducto(codigo, actualizado);
        return true;
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