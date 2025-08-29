/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

public interface Component {

    // Método para obtener el nombre del componente
    String getName();

    // Método para obtener la categoría del componente
    String getCategory();

    // Método para obtener el precio base del componente
    double getBasePrice();

    // Método para calcular el precio final del componente
    double getFinalPrice();
}