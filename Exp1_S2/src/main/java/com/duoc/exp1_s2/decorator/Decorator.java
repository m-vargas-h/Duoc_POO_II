/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */

public abstract class Decorator implements Component {
    protected Component componente;

    public Decorator(Component componente) {
        this.componente = componente;
    }

    public double getDescuento() {
        return 0.0; // Por defecto, sin descuento
    }

    @Override
    public double getPrecio() {
        return componente.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return componente.getDescripcion();
    }
}
