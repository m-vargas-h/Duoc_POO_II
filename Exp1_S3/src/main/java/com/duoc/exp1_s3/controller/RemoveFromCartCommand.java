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


public class RemoveFromCartCommand implements Command {

    private OrderController orderController;    // Controlador de órdenes
    private Product product;                    // Producto a remover

    // Constructor
    public RemoveFromCartCommand(OrderController orderController, Product product) {
        this.orderController = orderController;
        this.product = product;
    }

    // Ejecuta el comando para remover del carrito
    @Override
    public void execute() {
        orderController.removeProduct(product);
        System.out.println(product.getName() + " removido del carrito.");
    }
}