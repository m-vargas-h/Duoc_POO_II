/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */

public class Product implements Component {
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private String categoria;

    public Product(String nombre, double precioUnitario, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre() { 
        return nombre; 
    }

    public double getPrecioUnitario() { 
        return precioUnitario; 
    }

    public int getCantidad() { 
        return cantidad; 
    }

    public String getCategoria() { 
        return categoria; 
    }

    @Override
    public double getPrecio() {
        return precioUnitario * cantidad;
    }

    @Override
    public String getDescripcion() {
        return nombre + " x" + cantidad + " [$" + getPrecio() + "]";
    }
}