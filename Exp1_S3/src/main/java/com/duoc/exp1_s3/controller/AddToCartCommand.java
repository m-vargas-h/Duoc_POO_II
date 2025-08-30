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

public class AddToCartCommand implements Command {

    private ProductController productController;    // Controlador de productos
    private OrderController orderController;        // Controlador de órdenes
    private String productId;                       // ID del producto a agregar
    private int quantity;                           // Cantidad a agregar

    // Constructor
    public AddToCartCommand(ProductController productController, OrderController orderController, 
                            String productId, int quantity) {
        this.productController = productController;
        this.orderController = orderController;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Ejecuta el comando para agregar al carrito
    @Override
    public void execute() {
        if (productController.isAvailable(productId, quantity)) {
            Product product = productController.getProductById(productId);
            for (int i = 0; i < quantity; i++) {
                orderController.addProduct(product);
            }
            productController.reduceStock(productId, quantity);
            System.out.println(quantity + " x " + product.getName() + " agregado al carrito.");
        } else {
            System.out.println("stock insuficiente para el producto: " + productId);
        }
    }
}