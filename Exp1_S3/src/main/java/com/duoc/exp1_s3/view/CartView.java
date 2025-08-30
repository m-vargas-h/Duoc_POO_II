/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.view;

import com.duoc.exp1_s3.controller.OrderController;
import com.duoc.exp1_s3.model.Product;

import java.util.List;

/**
 *
 * @author mvarg
 */

public class CartView {

    private OrderController orderController; // Controlador de órdenes

    // Constructor
    public CartView(OrderController orderController) {
        this.orderController = orderController;
    }

    // Muestra el contenido del carrito de compras
    public void showCartContents() {
        List<Product> products = orderController.getOrder().getProducts();

        System.out.println("----- Carrito de compras -----");
        if (products.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        // Mostrar productos en el carrito
        for (Product p : products) {
            System.out.println("ID: " + p.getId() +
                               " | Nombre: " + p.getName() +
                               " | Categoría: " + p.getCategory() +
                               " | Precio: $" + p.getBasePrice());
        }

        // Mostrar totales
        System.out.println("Total sin descuento: $" + orderController.getTotalBeforeDiscount());
        System.out.println("Total con descuento: $" + orderController.getTotalAfterDiscount());
    }
}