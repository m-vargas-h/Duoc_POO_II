/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

public class Product {

    private String id;          // identificador único
    private String name;        // nombre del producto
    private String category;    // categoría del producto
    private double basePrice;   // precio base del producto
    private int stock;          // cantidad en stock

    // Constructor
    public Product(String id, String name, String category, double basePrice, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
        this.stock = stock;
    }

    // Getters
    public String getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public String getCategory() { 
        return category; 
    }

    public double getBasePrice() { 
        return basePrice; 
    }

    public int getStock() { 
        return stock; 
    }

    // Setters
    public void setName(String name) { 
        this.name = name; 
    }

    public void setCategory(String category) { 
        this.category = category; 
    }

    public void setBasePrice(double basePrice) { 
        this.basePrice = basePrice; 
    }

    public void setStock(int stock) { 
        this.stock = stock; 
    }

    // Utilidad
    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    public void reduceStock(int quantity) {
        if (isAvailable(quantity)) {
            stock -= quantity;
        }
    }
}
