/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

public class DiscountedProduct implements Component {
    
    // Componente que envuelve a un producto para aplicar un descuento
    private Product product;

    // Constructor que recibe un producto
    public DiscountedProduct(Product product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public String getCategory() {
        return product.getCategory();
    }

    // El precio base es el mismo que el del producto original
    @Override
    public double getBasePrice() {
        return product.getBasePrice();
    }

    // El precio final es el precio base sin descuento
    @Override
    public double getFinalPrice() {
        return product.getBasePrice();
    }
}
