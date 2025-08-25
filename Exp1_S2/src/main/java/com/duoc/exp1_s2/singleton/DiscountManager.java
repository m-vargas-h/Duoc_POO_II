/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.singleton;

/**
 *
 * @author mvarg
 */

import java.util.Map;

public class DiscountManager {
    private static DiscountManager instance; // Instancia única

    // Mapa de categorías y sus descuentos asociados
    private Map<String, Double> descuentosPorCategoria = Map.of(
        "Outdoor", 0.15,
        "Ropa", 0.10,
        "Calzado", 0.05
    );

    private DiscountManager() {
        
    }

    // Método para obtener la instancia única
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Método para obtener el descuento por categoría
    public double getDescuentoCategoria(String categoria) {
        return descuentosPorCategoria.getOrDefault(categoria, 0.0);
    }
}