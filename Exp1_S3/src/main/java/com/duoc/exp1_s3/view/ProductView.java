/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.view;

import com.duoc.exp1_s3.controller.ProductController;
import com.duoc.exp1_s3.model.*;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mvarg
 */

public class ProductView {

    private ProductController productController;    // Controlador de productos
    private User user;                              // Usuario actual

    // Constructor
    public ProductView(ProductController productController, User user) {
        this.productController = productController;
        this.user = user;
    }

    // Muestra la lista de productos disponibles
    public void showAvailableProducts() {
        List<Product> products = productController.getAllProducts();
        System.out.println("----- Productos disponibles -----");
        for (Product p : products) {
            System.out.println("ID: " + p.getId() +
                               " | Nombre: " + p.getName() +
                               " | Categoría: " + p.getCategory() +
                               " | Precio: $" + p.getBasePrice() +
                               " | Stock: " + p.getStock());
        }
    }

    // Muestra la información de un producto con el descuento aplicado
    public void showDiscountedProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto que desea consultar: ");
        String productId = scanner.nextLine();

        Component discounted = productController.getDiscountedProduct(productId, user);
        if (discounted != null) {
            System.out.println("----- Información con descuento aplicado -----");
            System.out.println("Nombre: " + discounted.getName());
            System.out.println("Categoría: " + discounted.getCategory());
            System.out.println("Precio original: $" + discounted.getBasePrice());
            System.out.println("Precio final: $" + discounted.getFinalPrice());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}