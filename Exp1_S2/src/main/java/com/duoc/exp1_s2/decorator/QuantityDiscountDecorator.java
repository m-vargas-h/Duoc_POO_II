/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */

import com.duoc.exp1_s2.singleton.DiscountManager;

public class QuantityDiscountDecorator extends Decorator {

    public QuantityDiscountDecorator(Component componente) {
        super(componente);
    }

    @Override
    public double getPrecio() {
        if (componente instanceof Product) {
            Product producto = (Product) componente;
            double base = producto.getPrecio();
            double porcentaje = DiscountManager.getInstance().calculateDiscountPercentage(producto.getCantidad());
            return base - (base * porcentaje / 100);
        }
        return componente.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return componente.getDescripcion() + " (descuento por cantidad)";
    }
}
