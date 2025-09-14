package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.duoc.gestioninventario.model.ProductoConEtiqueta;
import com.duoc.gestioninventario.model.ProductoConDescuento;
import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.util.ProductoUtils;

class ProductoUtilsTest {

    
    @Test
    void testObtenerProductoBaseDesdeDecoradoresAnidados() {
        Producto base = new Producto("001", "Monitor", "LED 24\"", 150.0, 5);
        Producto decorado = new ProductoConEtiqueta(new ProductoConDescuento(base, 10), "OFERTA");

        Producto resultado = ProductoUtils.obtenerProductoBase(decorado);

        assertEquals(base, resultado);
    }
}