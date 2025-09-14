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
 * Decorador que aplica un descuento porcentual al precio del producto.
 */
public class ProductoConDescuento extends ProductoDecorator {
    private final double porcentajeDescuento;

    public ProductoConDescuento(Producto productoBase, double porcentajeDescuento) {
        super(productoBase);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public Producto getProductoBase() {
        return productoBase;
    }

    @Override
    public double getPrecio() {
        return productoBase.getPrecio() * (1 - porcentajeDescuento / 100);
    }

    @Override
    public String getDescripcionDetallada() {
        return super.getDescripcionDetallada() +
               String.format(" | Descuento: %.1f%% | Precio final: %.2f",
                             porcentajeDescuento, getPrecio());
    }
}
