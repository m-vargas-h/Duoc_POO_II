/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.decorator;

/**
 *
 * @author mvarg
 */


public class CategoryDiscountDecorator extends Decorator {
    private String categoriaObjetivo;       // categoría a la que se aplica el descuento
    private double porcentaje;              // porcentaje de descuento (ej. 0.10 para 10%)
    private double descuentoAplicado = 0.0; // para rastrear el descuento aplicado

    // Constructor
    public CategoryDiscountDecorator(Component componente, String categoriaObjetivo, double porcentaje) {
        super(componente);
        this.categoriaObjetivo = categoriaObjetivo;
        this.porcentaje = porcentaje;
    }

    // Aplica el descuento si el producto pertenece a la categoría objetivo
    @Override
    public double getPrecio() {
        double precioOriginal = componente.getPrecio();
        Product p = extraerProducto(componente);
        if (p != null && p.getCategoria().equalsIgnoreCase(categoriaObjetivo)) {
            descuentoAplicado = precioOriginal * porcentaje;
            return precioOriginal - descuentoAplicado;
        }
        return precioOriginal;
    }

    // Actualiza la descripción para incluir el descuento aplicado
    @Override
    public String getDescripcion() {
        double precioFinal = getPrecio(); // fuerza el cálculo y actualiza descuentoAplicado
        if (descuentoAplicado > 0) {
            return componente.getDescripcion() + String.format(" (descuento por categoría: $%.0f)", 
                                                                descuentoAplicado);
        }
        return componente.getDescripcion();
    }

    // Retorna el monto del descuento aplicado
    @Override
    public double getDescuento() {
        return descuentoAplicado;
    }

    // Método auxiliar para extraer el producto original
    private Product extraerProducto(Component c) {
        if (c instanceof Product) return (Product) c;
        if (c instanceof Decorator) return extraerProducto(((Decorator) c).componente);
        return null;
    }

}