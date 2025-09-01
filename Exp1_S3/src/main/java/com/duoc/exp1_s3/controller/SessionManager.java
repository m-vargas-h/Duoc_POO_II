
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.User;

import java.util.Scanner;

public class SessionManager {

    private final UserController userController; // Controlador de usuarios

    // Constructor
    public SessionManager(UserController userController) {
        this.userController = userController;
    }

    // Método para iniciar sesión o registrarse
    public User iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Bienvenido al sistema de compras -----");
        System.out.print("¿Desea registrarse como nuevo usuario? (s/n): ");
        String respuesta = scanner.nextLine();

        // Registro de nuevo usuario
        if (respuesta.equalsIgnoreCase("s")) {
            userController.registerUserInteractive();
        } else {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar con RUT de usuario registrado");
            System.out.println("2. Ingresar como invitado");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine();

            // Iniciar sesión con RUT o como invitado
            if (opcion.equals("1")) {
                System.out.print("Ingrese su RUT (formato 01123456-k): ");
                String rut = scanner.nextLine();
                User encontrado = userController.getRegisteredUsers().stream()
                        .filter(u -> u.getId().equalsIgnoreCase(rut))
                        .findFirst()
                        .orElse(null);

                if (encontrado != null) {
                    userController.setCurrentUser(encontrado);
                    System.out.println("Bienvenido, " + encontrado.getName());
                } else {
                    System.out.println("Usuario no encontrado. Cerrando el sistema.");
                    return null;
                }
            } else if (opcion.equals("2")) {
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                User invitado = new User("INV-" + System.currentTimeMillis(), nombre, "", "Invitado");
                userController.setCurrentUser(invitado);
                System.out.println("Sesión iniciada como invitado.");
            } else {
                System.out.println("Opción inválida. Cerrando el sistema.");
                return null;
            }
        }

        return userController.getCurrentUser();
    }
}