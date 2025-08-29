/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;             // identificador único del pedido
    private User user;                  // usuario que realiza el pedido
    private List<Product> products;     // lista de productos en el pedido
    private double totalBeforeDiscount; // total antes de aplicar descuentos
    private double totalAfterDiscount;  // total después de aplicar descuentos

    // Constructor
    public Order(String orderId, User user) {
        this.orderId = orderId;
        this.user = user;
        this.products = new ArrayList<>();
        this.totalBeforeDiscount = 0.0;
        this.totalAfterDiscount = 0.0;
    }

    // Getters
    public String getOrderId() { 
        return orderId; 
    }

    public User getUser() { 
        return user; 
    }

    public List<Product> getProducts() { 
        return products; 
    }

    public double getTotalBeforeDiscount() { 
        return totalBeforeDiscount; 
    }

    public double getTotalAfterDiscount() { 
        return totalAfterDiscount; 
    }

    // Métodos de utilidad
    
    // Agrega un producto al pedido
    public void addProduct(Product product) {
        products.add(product);
        totalBeforeDiscount += product.getBasePrice();
    }

    // Elimina un producto del pedido
    public void removeProduct(Product product) {
        if (products.remove(product)) {
            totalBeforeDiscount -= product.getBasePrice();
        }
    }

    // Aplica un descuento al total
    public void applyDiscount(double discountedTotal) {
        this.totalAfterDiscount = discountedTotal;
    }

    // Verifica si la orden está vacía
    public boolean isEmpty() {
        return products.isEmpty();
    }
}