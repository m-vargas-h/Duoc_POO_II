package com.duoc.exp2_s4.util;

import com.duoc.exp2_s4.controller.Inventario;
import com.duoc.exp2_s4.model.*;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Clase encargada de guardar y cargar productos desde un archivo CSV.
 */
public class InventarioCsvManager {
    
    private static final String RUTA_ARCHIVO = "inventario.csv";

    public static void guardarInventario(Inventario inventario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Producto p : inventario.listarProductos().values()) {
                String etiqueta = "SIN_ETIQUETA";
                double descuento = 0.0;

                if (p instanceof ProductoConEtiqueta etiquetaDecorada) {
                    etiqueta = etiquetaDecorada.getEtiqueta();
                    p = etiquetaDecorada.getProductoBase(); // para evitar duplicar decoradores
                }

                if (p instanceof ProductoConDescuento descuentoDecorado) {
                    descuento = descuentoDecorado.getPorcentajeDescuento();
                    p = descuentoDecorado.getProductoBase();
                }

                String linea = String.format("%s,%s,%s,%.2f,%d,%s,%.1f",
                        p.getCodigo(), p.getNombre(), p.getDescripcion(),
                        p.getPrecio(), p.getCantidad(), etiqueta, descuento);

                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Inventario guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    public static void cargarInventario(Inventario inventario) {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("Archivo de inventario no encontrado. Se iniciará con inventario vacío.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                if (st.countTokens() == 7) {
                    String codigo = st.nextToken();
                    String nombre = st.nextToken();
                    String descripcion = st.nextToken();
                    double precio = Double.parseDouble(st.nextToken());
                    int cantidad = Integer.parseInt(st.nextToken());
                    String etiqueta = st.nextToken();
                    double descuento = Double.parseDouble(st.nextToken());

                    Producto producto = new Producto(codigo, nombre, descripcion, precio, cantidad);

                    if (!etiqueta.equals("SIN_ETIQUETA")) {
                        producto = new ProductoConEtiqueta(producto, etiqueta);
                    }

                    if (descuento > 0) {
                        producto = new ProductoConDescuento(producto, descuento);
                    }

                    inventario.agregarProducto(producto);
                }
            }
            System.out.println("Inventario cargado correctamente.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
        }
    }
}