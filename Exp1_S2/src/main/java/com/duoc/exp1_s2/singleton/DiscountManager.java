/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.singleton;

/**
 *
 * @author mvarg
 */

import java.util.HashMap;
import java.util.Map;

public class DiscountManager {
    private static DiscountManager instance;

    private Map<String, Double> descuentosPorCategoria = new HashMap<>();
    private Map<Integer, Double> descuentosPorCantidad = new HashMap<>();

    private DiscountManager() { }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    // Descuento por cantidad (configurable)
    public void setDescuentoCantidad(int cantidad, double porcentaje) {
        descuentosPorCantidad.put(cantidad, porcentaje);
    }

    public double getDescuentoCantidad(int cantidad) {
        return descuentosPorCantidad.getOrDefault(cantidad, calculateDiscountPercentage(cantidad));
    }

    // Lógica fija como fallback
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

    // Descuento por categoría
    public void setDescuentoCategoria(String categoria, double porcentaje) {
        descuentosPorCategoria.put(categoria, porcentaje);
    }

    public double getDescuentoCategoria(String categoria) {
        return descuentosPorCategoria.getOrDefault(categoria, 0.0);
    }
}