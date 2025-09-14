/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.duoc.gestioninventario.model.Producto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mvarg
 */
public class ProductoTest {

    @Test
    public void testCreacionProducto() {
        Producto producto = new Producto("CHL00001", "Pala", "Pala de acero", 1000.0, 10);

        assertEquals("CHL00001", producto.getCodigo());
        assertEquals("Pala", producto.getNombre());
        assertEquals("Pala de acero", producto.getDescripcion());
        assertEquals(1000.0, producto.getPrecio());
        assertEquals(10, producto.getCantidad());
    }

    @Test
    public void testActualizarPrecio() {
        Producto producto = new Producto("CHL00002", "Martillo", "Martillo de goma", 1500.0, 5);
        producto.setPrecio(1800.0);
        assertEquals(1800.0, producto.getPrecio());
    }

    @Test
    public void testActualizarCantidad() {
        Producto producto = new Producto("CHL00003", "Destornillador", "Philips", 800.0, 20);
        producto.setCantidad(25);
        assertEquals(25, producto.getCantidad());
    }
}