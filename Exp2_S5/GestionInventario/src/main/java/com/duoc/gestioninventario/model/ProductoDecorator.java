/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.model;

/**
 *
 * @author mvarg
 */

/**
 * Decorador abstracto para extender dinámicamente un producto.
 */
public abstract class ProductoDecorator extends Producto {
    protected final Producto productoBase;

    public ProductoDecorator(Producto productoBase) {
        super(productoBase.getCodigo(), productoBase.getNombre(), productoBase.getDescripcion(),
              productoBase.getPrecio(), productoBase.getCantidad());
        this.productoBase = productoBase;
    }

    public Producto getProductoBase() {
        return productoBase;
    }

    @Override
    public String getDescripcionDetallada() {
        return productoBase.getDescripcionDetallada();
    }
}
