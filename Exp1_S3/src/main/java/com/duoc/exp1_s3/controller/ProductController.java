/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.*;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author mvarg
 */

public class ProductController {

    private List<Product> productList; // Simula una base de datos

    public ProductController() {
        this.productList = new ArrayList<>();
        seedProducts(); // Carga inicial
    }

    // Cargar productos de ejemplo
    private void seedProducts() {
        productList.add(new Product("P001", "Camisa manga corta", "Ropa", 14980, 15));
        productList.add(new Product("P002", "Zapato Trekking", "Calzado", 95990, 8));
        productList.add(new Product("P003", "Cortavientos impermeable", "Ropa", 56790, 5));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    // Obtener producto por ID
    public Product getProductById(String id) {
        return productList.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    // Verificar disponibilidad
    public boolean isAvailable(String productId, int quantity) {
        Product product = getProductById(productId);
        return product != null && product.isAvailable(quantity);
    }

    // Aplicar descuentos y obtener producto con precio final
    public Component getDiscountedProduct(String productId, User user) {
        Product product = getProductById(productId);
        if (product == null) return null;

        DiscountManager dm = DiscountManager.getInstance();
        return dm.applyDiscounts(product, user);
    }

    // Reducir stock después de una compra
    public void reduceStock(String productId, int quantity) {
        Product product = getProductById(productId);
        if (product != null) {
            product.reduceStock(quantity);
        }
    }
}