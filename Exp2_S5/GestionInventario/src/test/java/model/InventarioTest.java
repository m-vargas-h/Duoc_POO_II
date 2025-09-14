/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.duoc.gestioninventario.controller.Inventario;
import com.duoc.gestioninventario.model.Producto;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mvarg
 */
public class InventarioTest {
    private Inventario inventario;

    @BeforeEach
    public void setUp() {
        inventario = Inventario.getInstancia();
        inventario.limpiar();
    }

    @Test
    public void testAgregarProducto() {
        Producto producto = new Producto("CHL00004", "Serrucho", "Manual", 1200.0, 7);
        boolean agregado = inventario.agregarProducto(producto);
        assertTrue(agregado);
        assertEquals(1, inventario.listarProductos().size());
    }

    @Test
    public void testAgregarProductoNulo() {
        boolean agregado = inventario.agregarProducto(null);
        assertFalse(agregado);
    }

    @Test
    public void testEliminarProductoExistente() {
        Producto producto = new Producto("CHL00005", "Taladro", "Eléctrico", 3000.0, 3);
        inventario.agregarProducto(producto);
        boolean eliminado = inventario.eliminarProducto("CHL00005");
        assertTrue(eliminado);
        assertNull(inventario.buscarPorCodigo("CHL00005"));
    }

    @Test
    public void testEliminarProductoInexistente() {
        boolean eliminado = inventario.eliminarProducto("CHL99999");
        assertFalse(eliminado);
    }

    @Test
    public void testBuscarPorTextoExistente() {
        inventario.agregarProducto(new Producto("CHL00006", "Sierra", "Sierra circular", 2500.0, 4));
        inventario.agregarProducto(new Producto("CHL00007", "Sierra manual", "Herramienta", 900.0, 6));

        Map<String, Producto> resultados = inventario.buscarPorTexto("sierra");

        assertEquals(2, resultados.size());
        assertTrue(resultados.containsKey("CHL00006"));
        assertTrue(resultados.containsKey("CHL00007"));
    }

    @Test
    public void testBuscarPorTextoInexistente() {
        inventario.agregarProducto(new Producto("CHL00008", "Llave inglesa", "Herramienta", 1100.0, 2));

        Map<String, Producto> resultados = inventario.buscarPorTexto("martillo");

        assertTrue(resultados.isEmpty());
    }

    @Test
    public void testListarProductos() {
        inventario.agregarProducto(new Producto("CHL00009", "Cinta métrica", "Medición", 500.0, 10));
        inventario.agregarProducto(new Producto("CHL00010", "Nivel", "Nivel de burbuja", 700.0, 5));

        Map<String, Producto> productos = inventario.listarProductos();
        
        assertEquals(2, productos.size());
        assertTrue(productos.containsKey("CHL00009"));
        assertTrue(productos.containsKey("CHL00010"));
    }
}