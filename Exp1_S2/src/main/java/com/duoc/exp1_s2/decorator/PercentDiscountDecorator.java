/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */

public class PercentDiscountDecorator extends Decorator {
    private double porcentaje;

    // Constructor
    public PercentDiscountDecorator(Component componente, double porcentaje) {
        super(componente);
        this.porcentaje = porcentaje;
    }

    // Métodos
    @Override
    public double getPrecio() {
        double base = componente.getPrecio();
        return base - (base * porcentaje / 100); // Aplicar descuento porcentual
    }

    @Override
    public String getDescripcion() {
        return componente.getDescripcion() + " (descuento fijo " + porcentaje + "%)";
    }
}