/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp2_s4.controller;

import com.duoc.exp2_s4.model.Producto;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase encargada de gestionar el inventario de productos.
 * Permite agregar, eliminar, buscar y listar productos.
 */
public class Inventario {
    private Map<String, Producto> productos;

    /**
     * Constructor que inicializa el inventario vacío.
     */
    public Inventario() {
        productos = new HashMap<>();
    }

    /**
     * Agrega un nuevo producto al inventario.
     *
     * @param producto Producto a agregar
     * @return true si se agregó correctamente, false si el código ya existe
     */
    public boolean agregarProducto(Producto producto) {
        if (productos.containsKey(producto.getCodigo())) {
            return false;
        }
        productos.put(producto.getCodigo(), producto);
        return true;
    }

    /**
     * Elimina un producto del inventario por su código.
     *
     * @param codigo Código del producto a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarProducto(String codigo) {
        return productos.remove(codigo) != null;
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo Código del producto
     * @return Producto encontrado o null si no existe
     */
    public Producto buscarPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    /**
     * Busca productos que contengan el texto especificado en su nombre o descripción.
     *
     * @param texto Texto a buscar
     * @return Mapa con los productos que coinciden
     */
    public Map<String, Producto> buscarPorTexto(String texto) {
        Map<String, Producto> resultados = new HashMap<>();
        String textoNormalizado = texto.toLowerCase();

        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            Producto p = entry.getValue();
            if (p.getNombre().toLowerCase().contains(textoNormalizado) ||
                p.getDescripcion().toLowerCase().contains(textoNormalizado)) {
                resultados.put(entry.getKey(), p);
            }
        }
        return resultados;
    }

    /**
     * Lista todos los productos del inventario.
     *
     * @return Mapa con todos los productos registrados
     */
    public Map<String, Producto> listarProductos() {
        return new HashMap<>(productos); // Retorna una copia para evitar modificaciones externas
    }

    /**
     * Actualiza la cantidad disponible de un producto.
     *
     * @param codigo Código del producto
     * @param nuevaCantidad Nueva cantidad a establecer
     * @return true si se actualizó correctamente, false si el producto no existe
     */
    public boolean actualizarCantidad(String codigo, int nuevaCantidad) {
        Producto producto = productos.get(codigo);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    /**
     * Actualiza la información completa de un producto existente.
     *
     * @param codigo Código del producto a actualizar
     * @param nuevoNombre Nuevo nombre del producto
     * @param nuevaDescripcion Nueva descripción del producto
     * @param nuevoPrecio Nuevo precio del producto
     * @param nuevaCantidad Nueva cantidad disponible
     * @return true si se actualizó correctamente, false si el producto no existe
     */
    public boolean actualizarProducto(String codigo, String nuevoNombre, String nuevaDescripcion,
                                      double nuevoPrecio, int nuevaCantidad) {
        Producto producto = productos.get(codigo);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setDescripcion(nuevaDescripcion);
            producto.setPrecio(nuevoPrecio);
            producto.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }



    /**
     * Verifica si el inventario está vacío.
     *
     * @return true si no hay productos registrados
     */
    public boolean estaVacio() {
        return productos.isEmpty();
    }
}