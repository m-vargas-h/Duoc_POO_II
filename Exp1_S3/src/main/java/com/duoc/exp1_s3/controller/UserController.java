/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.User;

/**
 *
 * @author mvarg
 */

public class UserController {

    private User currentUser; // Usuario actual

    // Constructor
    public UserController(User user) {
        this.currentUser = user;
    }

    // Obtiene el usuario actual
    public User getCurrentUser() {
        return currentUser;
    }

    // Actualiza el tipo de usuario (normal, premium, staff)
    public void updateUserType(String newType) {
        currentUser.setUserType(newType);
        System.out.println("Tipo de usuario actualizado a: " + newType);
    }

    // Muestra información del usuario
    public void showUserInfo() {
        System.out.println("Usuario actual:");
        System.out.println("Nombre: " + currentUser.getName());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Tipo: " + currentUser.getUserType());
    }

    // Verifica el tipo de usuario
    public boolean isPremium() {
        return currentUser.isPremium();
    }

    // Verifica si el usuario es staff
    public boolean isStaff() {
        return currentUser.isStaff();
    }
}