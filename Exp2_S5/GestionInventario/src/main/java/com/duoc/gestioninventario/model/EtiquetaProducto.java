/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.gestioninventario.model;

/**
 *
 * @author mvarg
 */

/**
 * Enumeración de etiquetas disponibles para productos.
 */
public enum EtiquetaProducto {
    BOOSTER_PACK,
    BATTLE_DECK,
    ELITE_TRAINER_BOX,
    BLISTER,
    PRODUCTO_ESPECIAL,
    SIN_ETIQUETA;

    public static void mostrarOpciones() {
        System.out.println("Seleccione una etiqueta:");
        for (int i = 0; i < values().length; i++) {
            System.out.printf("%d. %s%n", i + 1, values()[i].name().replace("_", " "));
        }
    }

    public static EtiquetaProducto obtenerPorIndice(int indice) {
        if (indice < 1 || indice > values().length) return SIN_ETIQUETA;
        return values()[indice - 1];
    }
}
