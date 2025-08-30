/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.view;

import com.duoc.exp1_s3.model.DiscountManager;

import java.util.Map;

/**
 *
 * @author mvarg
 */

public class DiscountView {

    private DiscountManager discountManager; // Gestor de descuentos

    // Constructor
    public DiscountView() {
        this.discountManager = DiscountManager.getInstance();
    }

    // Muestra los descuentos disponibles
    public void showUserTypeDiscounts() {
        System.out.println("----- Descuentos por tipo de usuario -----");
        Map<String, Double> userDiscounts = discountManager.getUserTypeDiscounts();
        if (userDiscounts.isEmpty()) {
            System.out.println("No hay descuentos definidos para tipos de usuario.");
        } else {
            userDiscounts.forEach((type, percent) ->
                System.out.println("Tipo: " + type + " → " + percent + "% de descuento")
            );
        }
    }

    // Muestra los descuentos por categoría de producto
    public void showCategoryDiscounts() {
        System.out.println("----- Descuentos por categoría de producto -----");
        Map<String, Double> categoryDiscounts = discountManager.getCategoryDiscounts();
        if (categoryDiscounts.isEmpty()) {
            System.out.println("No hay descuentos definidos por categoría.");
        } else {
            categoryDiscounts.forEach((category, percent) ->
                System.out.println("Categoría: " + category + " → " + percent + "% de descuento")
            );
        }
    }
}