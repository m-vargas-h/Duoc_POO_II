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
        System.out.println("Producto agregado: " + producto.getDescripcion());
    }

    public void eliminarProducto(Component producto) {
        productos.remove(producto);
        System.out.println("Producto eliminado: " + producto.getDescripcion());
    }

    public double calcularTotal() {
        return productos.stream()
                        .mapToDouble(Component::getPrecio)
                        .sum();
    }

    public void mostrarCarrito() {
        System.out.println("Contenido del carrito:");
        productos.forEach(p -> System.out.println("- " + p.getDescripcion()));
        System.out.println("Total: $" + calcularTotal());
    }
}