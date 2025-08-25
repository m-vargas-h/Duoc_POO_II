/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */

public class CategoryDiscountDecorator extends Decorator {
    private String categoriaObjetivo;
    private double porcentaje;

    public CategoryDiscountDecorator(Component componente, String categoriaObjetivo, double porcentaje) {
        super(componente);
        this.categoriaObjetivo = categoriaObjetivo;
        this.porcentaje = porcentaje;
    }

    @Override
    public double getPrecio() {
        if (componente instanceof Product) {
            Product producto = (Product) componente;
            if (producto.getCategoria().equalsIgnoreCase(categoriaObjetivo)) {
                double base = producto.getPrecio();
                return base - (base * porcentaje / 100);
            }
        }
        return componente.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return componente.getDescripcion() + " (descuento por categoría)";
    }
}