
package com.duoc.exp2_s4.util;

import com.duoc.exp2_s4.controller.Inventario;
import com.duoc.exp2_s4.model.Producto;

/**
 * Generador automático de códigos de producto con formato CHL00001.
 */
public class CodigoProductoGenerator {
    private static final String PREFIJO = "CHL";

    /**
     * Genera el siguiente código disponible en el inventario.
     *
     * @param inventario Inventario actual
     * @return Código generado
     */
    public static String generarCodigo(Inventario inventario) {
        return PREFIJO + String.format("%05d", obtenerUltimoNumero(inventario) + 1);
    }

    /**
     * Busca el número más alto usado en los códigos actuales.
     *
     * @param inventario Inventario actual
     * @return Último número usado
     */
    private static int obtenerUltimoNumero(Inventario inventario) {
        return inventario.listarProductos().values().stream()
            .map(Producto::getCodigo)
            .filter(codigo -> codigo.startsWith(PREFIJO))
            .map(codigo -> codigo.substring(PREFIJO.length()))
            .filter(numeros -> numeros.matches("\\d{5}"))
            .mapToInt(Integer::parseInt)
            .max()
            .orElse(0);
    }
}
