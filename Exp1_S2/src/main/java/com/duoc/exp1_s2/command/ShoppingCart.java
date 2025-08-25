/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.command;

/**
 *
 * @author mvarg
 */

import com.duoc.exp1_s2.decorator.Component;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Component> productos = new ArrayList<>();

    public void agregarProducto(Component producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Component producto) {
        productos.remove(producto);
    }

    public void mostrarCarrito() {
        double total = 0;
        for (Component p : productos) {
            System.out.println("- " + p.getDescripcion());
            total += p.getPrecio();
        }
        System.out.printf("Total: $%.0f\n", total);
    }
}