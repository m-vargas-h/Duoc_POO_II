package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.duoc.gestioninventario.model.ProductoConEtiqueta;
import com.duoc.gestioninventario.model.ProductoConDescuento;
import com.duoc.gestioninventario.model.Producto;

class ProductoDecoratorTest {

    @Test
    void testDescripcionDetalladaConEtiquetaYDescuento() {
        Producto base = new Producto("002", "Teclado", "Mecánico RGB", 80.0, 10);
        Producto decorado = new ProductoConEtiqueta(new ProductoConDescuento(base, 20), "GAMER");

        String descripcion = decorado.getDescripcionDetallada();

        assertTrue(descripcion.contains("Etiqueta: GAMER"));
        assertTrue(descripcion.contains("Descuento: 20%"));
    }
}