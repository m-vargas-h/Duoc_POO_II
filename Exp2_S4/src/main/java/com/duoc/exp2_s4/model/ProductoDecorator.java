package com.duoc.exp2_s4.model;

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

    @Override
    public String getDescripcionDetallada() {
        return productoBase.getDescripcionDetallada();
    }
}