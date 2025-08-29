/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

public class PercentDiscountDecorator implements Component {

    private Component component;    // Componente que envuelve 
    private double discountPercent; // Porcentaje de descuento

    // Constructor que recibe un componente y el porcentaje de descuento
    public PercentDiscountDecorator(Component component, double discountPercent) {
        this.component = component;
        this.discountPercent = discountPercent;
    }

    @Override
    public String getName() {
        return component.getName();
    }

    @Override
    public String getCategory() {
        return component.getCategory();
    }

    @Override
    public double getBasePrice() {
        return component.getBasePrice();
    }

    // getFinalPrice aplica el descuento porcentual al precio final del componente
    @Override
    public double getFinalPrice() {
        double basePrice = component.getFinalPrice();
        double discount = basePrice * (discountPercent / 100.0);
        return basePrice - discount;
    }
}