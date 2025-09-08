/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.duoc.exp2_s4.controller.Inventario;
import com.duoc.exp2_s4.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventarioIntegracionTest {
    private Inventario inventario;

    @BeforeEach
    public void setUp() {
        inventario = Inventario.getInstancia();
        inventario.limpiar(); // Método auxiliar para vaciar el inventario antes de cada prueba
    }

    @Test
    public void testAgregarProducto() {
        Producto producto = new Producto("CHL00001", "Pala", "Pala de acero", 1000.0, 10);
        boolean agregado = inventario.agregarProducto(producto);
        assertTrue(agregado);
        assertEquals(1, inventario.listarProductos().size());
    }

    @Test
    public void testBuscarProducto() {
        Producto producto = new Producto("CHL00002", "Martillo", "Martillo de goma", 1500.0, 5);
        inventario.agregarProducto(producto);
        Producto resultado = inventario.buscarPorCodigo("CHL00002");
        assertNotNull(resultado);
        assertEquals("Martillo", resultado.getNombre());
    }

    @Test
    public void testEliminarProducto() {
        Producto producto = new Producto("CHL00003", "Destornillador", "Philips", 800.0, 20);
        inventario.agregarProducto(producto);
        boolean eliminado = inventario.eliminarProducto("CHL00003");
        assertTrue(eliminado);
        assertNull(inventario.buscarPorCodigo("CHL00003"));
        assertEquals(0, inventario.listarProductos().size());
    }
}
