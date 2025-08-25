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
    private double descuentoAplicado = 0.0;

    public CategoryDiscountDecorator(Component componente, String categoriaObjetivo, double porcentaje) {
        super(componente);
        this.categoriaObjetivo = categoriaObjetivo;
        this.porcentaje = porcentaje;
    }

    @Override
    public double getPrecio() {
        double precioOriginal = componente.getPrecio();
        Product p = extraerProducto(componente);
        if (p != null && p.getCategoria().equalsIgnoreCase(categoriaObjetivo)) {
            descuentoAplicado = precioOriginal * porcentaje;
            return precioOriginal - descuentoAplicado;
        }
        return precioOriginal;
    }

    @Override
    public String getDescripcion() {
        double precioFinal = getPrecio(); // fuerza el cálculo y actualiza descuentoAplicado
        if (descuentoAplicado > 0) {
            return componente.getDescripcion() + String.format(" (descuento por categoría: $%.0f)", 
                                                                descuentoAplicado);
        }
        return componente.getDescripcion();
    }

    @Override
    public double getDescuento() {
        return descuentoAplicado;
    }

    private Product extraerProducto(Component c) {
        if (c instanceof Product) return (Product) c;
        if (c instanceof Decorator) return extraerProducto(((Decorator) c).componente);
        return null;
    }

}