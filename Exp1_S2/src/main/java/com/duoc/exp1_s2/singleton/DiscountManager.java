/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.singleton;

/**
 *
 * @author mvarg
 */

public class DiscountManager {
    // Instancia única (Singleton)
    private static DiscountManager instance;

    // Constructor privado
    private DiscountManager() { }

    // Método de acceso público
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Lógica de descuento por cantidad
    public double calculateDiscountPercentage(int quantity) {
        if (quantity >= 10) {
            return 15.0;
        } else if (quantity >= 5) {
            return 10.0;
        } else if (quantity >= 3) {
            return 5.0;
        } else {
            return 0.0;
        }
    }
}