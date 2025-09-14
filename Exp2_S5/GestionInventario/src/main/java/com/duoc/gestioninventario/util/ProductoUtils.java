/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.util;

import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.model.ProductoDecorator;

/**
 *
 * @author mvarg
 */

public class ProductoUtils {

    /**
     * Devuelve el producto base, removiendo todos los decoradores.
     * @param producto Producto decorado o base
     * @return Producto original sin decoradores
     */
    public static Producto obtenerProductoBase(Producto producto) {
        while (producto instanceof ProductoDecorator) {
            producto = ((ProductoDecorator) producto).getProductoBase();
        }
        return producto;
    }

    /**
     * Verifica si el producto tiene algún decorador aplicado.
     * @param producto Producto a evaluar
     * @return true si está decorado, false si es base
     */
    public static boolean estaDecorado(Producto producto) {
        return producto instanceof ProductoDecorator;
    }

    /**
     * Devuelve el decorador más externo (si existe).
     * @param producto Producto decorado o base
     * @return Decorador externo o null si no hay
     */
    public static ProductoDecorator obtenerDecoradorExterno(Producto producto) {
        if (producto instanceof ProductoDecorator decorador) {
            return decorador;
        }
        return null;
    }
}
