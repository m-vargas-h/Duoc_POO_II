/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

import com.duoc.gestioninventario.controller.Inventario;
import com.duoc.gestioninventario.model.Producto;
import com.duoc.gestioninventario.model.ProductoConDescuento;
import com.duoc.gestioninventario.model.ProductoConEtiqueta;
import java.nio.file.Paths;

/**
 *
 * @author mvarg
 */

/**
 * Clase encargada de guardar y cargar productos desde un archivo CSV.
 */
public class InventarioCsvManager {

    private static final String FOLDER_PATH = "../data";
    private static final String FILE_PATH = Paths.get(System.getProperty("user.dir"), "..", "data", "inventario.csv").normalize().toString();
    //private static final String FILE_PATH = "..data/inventario.csv";

    public static void guardarInventario(Inventario inventario) {
        try {
            File carpeta = new File(FOLDER_PATH);
            if (!carpeta.exists()) {
                boolean creada = carpeta.mkdirs();
                if (!creada) {
                    System.out.println("No se pudo crear la carpeta de datos.");
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Producto p : inventario.listarProductos().values()) {
                    String etiqueta = "SIN_ETIQUETA";
                    double descuento = 0.0;

                    if (p instanceof ProductoConEtiqueta etiquetaDecorada) {
                        etiqueta = etiquetaDecorada.getEtiqueta();
                        p = etiquetaDecorada.getProductoBase();
                    }

                    if (p instanceof ProductoConDescuento descuentoDecorada) {
                        descuento = descuentoDecorada.getPorcentajeDescuento();
                        p = descuentoDecorada.getProductoBase();
                    }

                    String linea = String.format(Locale.US, "%s,%s,%s,%.2f,%d,%s,%.1f",
                        p.getCodigo(), p.getNombre(), p.getDescripcion(),
                        p.getPrecio(), p.getCantidad(), etiqueta, descuento);

                    writer.write(linea);
                    writer.newLine();
                }
            }

            System.out.println("Inventario guardado en: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    public static void cargarInventario(Inventario inventario) {
        File archivo = new File(FILE_PATH);
        if (!archivo.exists()) {
            System.out.println("Archivo de inventario no encontrado en: " + FILE_PATH);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
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

            System.out.println("Inventario cargado desde: " + FILE_PATH);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
        }
    }
}