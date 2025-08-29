/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

import java.util.Map;

public class CategoryDiscountDecorator implements Component {

    private Component component; 
    private Map<String, Double> categoryDiscounts; // Mapa de categorías a descuentos porcentuales

    // Constructor que recibe un componente y el mapa de descuentos por categoría
    public CategoryDiscountDecorator(Component component, Map<String, Double> categoryDiscounts) {
        this.component = component;
        this.categoryDiscounts = categoryDiscounts;
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

    // getFinalPrice aplica el descuento basado en la categoría
    @Override
    public double getFinalPrice() {
        double basePrice = component.getFinalPrice(); // Puede venir ya decorado
        double discountPercent = categoryDiscounts.getOrDefault(getCategory(), 0.0);
        double discount = basePrice * (discountPercent / 100.0);
        return basePrice - discount;
    }
}
