/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.User;
import com.duoc.exp1_s3.util.UserCsvManager;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mvarg
 */

public class UserController {

    private List<User> registeredUsers;     // Lista de usuarios registrados
    private User currentUser;               // Usuario actualmente activo

    // Constructor
    public UserController() {
        this.registeredUsers = UserCsvManager.loadUsers();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    // Registro de un nuevo usuario
    public void registerUserInteractive() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Registro de nuevo usuario -----");

        System.out.print("Nombre completo: ");
        String name = scanner.nextLine();

        System.out.print("RUT (formato 01123456-k): ");
        String rut = scanner.nextLine();

        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();

        System.out.print("Tipo de usuario (Staff / Normal / VIP): ");
        String type = scanner.nextLine();

        // Validación básica de datos
        if (isValidRut(rut) && isValidEmail(email) && isValidUserType(type)) {
            User newUser = new User(rut, name, email, type);
            registeredUsers.add(newUser);
            UserCsvManager.saveUser(newUser);
            setCurrentUser(newUser);
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Datos inválidos. Intente nuevamente.");
        }
    }

    // Validaciones simple de RUT, email y tipo de usuario
    private boolean isValidRut(String rut) {
        return rut.matches("\\d{8}-[kK\\d]");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isValidUserType(String type) {
        return type.equalsIgnoreCase("Staff") ||
               type.equalsIgnoreCase("Normal") ||
               type.equalsIgnoreCase("VIP");
    }

    // Muestra la información del usuario actual
    public void showUserInfo() {
        if (currentUser == null) {
            System.out.println("No hay usuario activo.");
            return;
        }

        System.out.println("----- Usuario actual -----");
        System.out.println("Nombre: " + currentUser.getName());
        System.out.println("RUT: " + currentUser.getId());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Tipo: " + currentUser.getUserType());
    }

    public boolean isPremium() {
        return currentUser != null && currentUser.getUserType().equalsIgnoreCase("VIP");
    }

    public boolean isStaff() {
        return currentUser != null && currentUser.getUserType().equalsIgnoreCase("Staff");
    }
}