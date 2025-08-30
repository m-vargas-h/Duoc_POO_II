/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

import java.util.HashMap;
import java.util.Map;

public class DiscountManager {

    private static DiscountManager instance; // instancia singleton

    private Map<String, Double> categoryDiscounts; // Mapa de categorías a descuentos porcentuales
    private Map<String, Double> userTypeDiscounts; // Mapa de tipos de usuario a descuentos porcentuales

    // Constructor privado para singleton
    private DiscountManager() {
        categoryDiscounts = new HashMap<>();
        userTypeDiscounts = new HashMap<>();
    }

    // Método para obtener la instancia singleton
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Configuración
    public void setCategoryDiscount(String category, double percent) {
        categoryDiscounts.put(category, percent);
    }

    public void setUserTypeDiscount(String userType, double percent) {
        userTypeDiscounts.put(userType, percent);
    }

    // Aplicación de descuentos
    public Component applyDiscounts(Product product, User user) {
        Component base = new DiscountedProduct(product);

        // Descuento por tipo de usuario
        double userDiscount = userTypeDiscounts.getOrDefault(user.getUserType(), 0.0);
        if (userDiscount > 0) {
            base = new PercentDiscountDecorator(base, userDiscount);
        }

        // Descuento por categoría
        double categoryDiscount = categoryDiscounts.getOrDefault(product.getCategory(), 0.0);
        if (categoryDiscount > 0) {
            Map<String, Double> categoryMap = new HashMap<>();
            categoryMap.put(product.getCategory(), categoryDiscount);
            base = new CategoryDiscountDecorator(base, categoryMap);
        }

        return base;
    }

    public Map<String, Double> getUserTypeDiscounts() {
        return userTypeDiscounts;
    }

    public Map<String, Double> getCategoryDiscounts() {
        return categoryDiscounts;
    }
}