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

public class AddToCartCommand implements Command {
    private ShoppingCart carrito;
    private Component producto;

    public AddToCartCommand(ShoppingCart carrito, Component producto) {
        this.carrito = carrito;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        carrito.agregarProducto(producto);
    }
}