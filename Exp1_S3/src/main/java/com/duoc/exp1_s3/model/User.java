/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.model;

/**
 *
 * @author mvarg
 */

public class User {
    
    private String id;          // identificador único
    private String name;        // nombre del usuario
    private String email;       // correo electrónico del usuario
    private String userType;    // tipo de usuario (e.g., "Regular", "Premium", "Staff")

    // Constructor
    public User(String id, String name, String email, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    // Getters
    public String getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public String getEmail() { 
        return email; 
    }

    public String getUserType() { 
        return userType; 
    }

    // Setters
    public void setName(String name) { 
        this.name = name; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public void setUserType(String userType) { 
        this.userType = userType; 
    }

    // Utilidad
    public boolean isPremium() {
        return "Premium".equalsIgnoreCase(userType);
    }

    public boolean isStaff() {
        return "Staff".equalsIgnoreCase(userType);
    }
}
