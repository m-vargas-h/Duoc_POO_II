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
 * Decorador que añade una etiqueta personalizada al producto.
 */
public class ProductoConEtiqueta extends ProductoDecorator {
    private final String etiqueta;

    // Constructor que inicializa el decorador con el producto base y la etiqueta.
    public ProductoConEtiqueta(Producto productoBase, String etiqueta) {
        super(productoBase);
        this.etiqueta = etiqueta;
    }

    // Getter para la etiqueta
    public String getEtiqueta() {
        return etiqueta;
    }

    // Getter para el producto base
    public Producto getProductoBase() {
        return productoBase;
    }

    @Override
    public String getDescripcionDetallada() {
        return super.getDescripcionDetallada() + " | Etiqueta: " + etiqueta;
    }
}
