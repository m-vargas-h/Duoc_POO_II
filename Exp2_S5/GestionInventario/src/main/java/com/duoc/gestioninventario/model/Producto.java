/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.model;

/**
 *
 * @author mvarg
 */

/**
 * Representa un producto dentro del sistema de inventario.
 * Contiene información básica como código, nombre, descripción, precio y cantidad disponible.
 */

public class Producto {

    private String codigo;      // Código único del producto
    private String nombre;      // Nombre del producto
    private String descripcion; // Descripción detallada del producto
    private double precio;      // Precio unitario del producto
    private int cantidad;       // Cantidad disponible en inventario

    /**
     * Constructor para crear un nuevo producto.
     *
     * @param codigo Código único del producto
     * @param nombre Nombre del producto
     * @param descripcion Descripción detallada del producto
     * @param precio Precio unitario del producto
     * @param cantidad Cantidad disponible en inventario
     */
    public Producto(String codigo, String nombre, String descripcion, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos getters

    /** @return Código del producto */
    public String getCodigo() {
        return codigo;
    }

    /** @return Nombre del producto */
    public String getNombre() {
        return nombre;
    }

    /** @return Descripción del producto */
    public String getDescripcion() {
        return descripcion;
    }

    /** @return Precio del producto */
    public double getPrecio() {
        return precio;
    }

    /** @return Cantidad disponible del producto */
    public int getCantidad() {
        return cantidad;
    }

    // Métodos setters

    /**
     * Actualiza el precio del producto.
     * @param nuevoPrecio Nuevo valor para el precio
     */
    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    /**
     * Actualiza la cantidad disponible del producto.
     * @param nuevaCantidad Nuevo valor para la cantidad
     */
    public void setCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    /**
     * Actualiza el nombre del producto.
     * @param nuevoNombre Nuevo valor para el nombre
     */
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Actualiza la descripción del producto.
     * @param nuevaDescripcion Nuevo valor para la descripción
     */
    public void setDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    /**
     * Devuelve una descripción completa del producto.
     * @return Cadena con todos los datos relevantes del producto
     */
    public String getDescripcionDetallada() {
        return String.format("Código: %s | Nombre: %s | Precio: %.2f | Cantidad: %d | Descripción: %s",
                codigo, nombre, precio, cantidad, descripcion);
    }


}