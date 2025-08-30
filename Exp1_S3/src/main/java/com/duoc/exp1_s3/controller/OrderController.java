/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.*;

/**
 *
 * @author mvarg
 */

public class OrderController {

    private Order currentOrder; // Orden actual

    // Inicializa una nueva orden para un usuario
    public OrderController(User user) {
        this.currentOrder = new Order(generateOrderId(), user);
    }

    // Genera un ID simple para la orden
    private String generateOrderId() {
        return "ORD-" + System.currentTimeMillis();
    }

    public Order getOrder() {
        return currentOrder;
    }

    public void addProduct(Product product) {
        currentOrder.addProduct(product);
    }

    public void removeProduct(Product product) {
        currentOrder.removeProduct(product);
    }

    // Aplica descuentos a todos los productos en la orden
    public void applyDiscounts(DiscountManager dm) {
        double total = 0.0;
        for (Product p : currentOrder.getProducts()) {
            Component discounted = dm.applyDiscounts(p, currentOrder.getUser());
            total += discounted.getFinalPrice();
        }
        currentOrder.applyDiscount(total);
    }

    // Obtiene totales antes y después de descuentos
    public double getTotalBeforeDiscount() {
        return currentOrder.getTotalBeforeDiscount();
    }

    public double getTotalAfterDiscount() {
        return currentOrder.getTotalAfterDiscount();
    }

    // Verifica si la orden está vacía
    public boolean isEmpty() {
        return currentOrder.isEmpty();
    }
}