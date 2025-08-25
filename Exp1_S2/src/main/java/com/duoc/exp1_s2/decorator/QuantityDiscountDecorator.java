/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */


public class QuantityDiscountDecorator extends Decorator {
    private double descuentoAplicado = 0.0;

    public QuantityDiscountDecorator(Component componente) {
        super(componente);
    }

    @Override
    public double getPrecio() {
        double precioOriginal = componente.getPrecio();
        if (componente instanceof Product) {
            Product p = (Product) componente;
            if (p.getCantidad() >= 3) {
                descuentoAplicado = precioOriginal * 0.10;
                return precioOriginal - descuentoAplicado;
            }
        }
        return precioOriginal;
    }

    @Override
    public String getDescripcion() {
        double precioFinal = getPrecio(); // fuerza el cálculo y actualiza descuentoAplicado
        if (descuentoAplicado > 0) {
            return componente.getDescripcion() + String.format(" (descuento por cantidad: $%.0f)", 
                                                                descuentoAplicado);
        }
        return componente.getDescripcion();
    }

    @Override
    public double getDescuento() {
        return descuentoAplicado;
    }

}

