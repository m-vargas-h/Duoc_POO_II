/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.duoc.exp1_s3;

import com.duoc.exp1_s3.controller.*;
import com.duoc.exp1_s3.model.*;
import com.duoc.exp1_s3.view.*;

import java.util.Scanner;

public class Exp1_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();

        System.out.println("----- Bienvenido al sistema de compras -----");
        System.out.print("¿Desea registrarse como nuevo usuario? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            userController.registerUserInteractive();
        } else {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar con RUT de usuario registrado");
            System.out.println("2. Ingresar como invitado");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine();

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
                    return;
                }
            } else if (opcion.equals("2")) {
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                User invitado = new User("INV-" + System.currentTimeMillis(), nombre, "", "Invitado");
                userController.setCurrentUser(invitado);
                System.out.println("Sesión iniciada como invitado.");
            } else {
                System.out.println("Opción inválida. Cerrando el sistema.");
                return;
            }
        }

        User user = userController.getCurrentUser();
        ProductController productController = new ProductController();
        OrderController orderController = new OrderController(user);
        Invoker invoker = new Invoker();

        ProductView productView = new ProductView(productController, user);
        CartView cartView = new CartView(orderController);
        DiscountView discountView = new DiscountView();

        DiscountManager dm = DiscountManager.getInstance();
        dm.setUserTypeDiscount("VIP", 15.0);
        dm.setUserTypeDiscount("Staff", 20.0);
        dm.setCategoryDiscount("Ropa", 10.0);
        dm.setCategoryDiscount("Calzado", 5.0);

        boolean running = true;

        while (running) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Ver productos disponibles");
            System.out.println("2. Consultar precio con descuento");
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Ver descuentos configurados");
            System.out.println("6. Ver información del usuario");
            System.out.println("7. Proceder al pago");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    productView.showAvailableProducts();
                    break;

                case "2":
                    productView.showDiscountedProduct();
                    break;

                case "3":
                    System.out.print("Ingrese ID del producto: ");
                    String productId = scanner.nextLine();
                    System.out.print("Ingrese cantidad: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    Command addCommand = new AddToCartCommand(productController, orderController, productId, quantity);
                    invoker.executeCommand(addCommand);
                    break;

                case "4":
                    cartView.showCartContents();
                    break;

                case "5":
                    discountView.showUserTypeDiscounts();
                    discountView.showCategoryDiscounts();
                    break;

                case "6":
                    userController.showUserInfo();
                    break;

                case "7":
                    if (orderController.isEmpty()) {
                        System.out.println("El carrito está vacío. No se puede proceder al pago.");
                        break;
                    }

                    // Aplicar descuentos automáticamente
                    orderController.applyDiscounts(dm);

                    // Mostrar resumen de compra
                    System.out.println("=== Resumen de la compra ===");
                    System.out.println("Cantidad de productos: " + orderController.getOrder().getProducts().size());
                    System.out.println("Total sin descuento: $" + orderController.getTotalBeforeDiscount());
                    System.out.println("Total con descuento: $" + orderController.getTotalAfterDiscount());

                    // Menú de pago
                    System.out.println("\n=== Menú de pago ===");
                    System.out.println("1. Pagar con débito");
                    System.out.println("2. Pagar con crédito");
                    System.out.println("3. Cancelar compra");
                    System.out.print("Seleccione una opción: ");
                    String metodoPago = scanner.nextLine();

                    if (metodoPago.equals("1") || metodoPago.equals("2")) {
                        String correoDestino;

                        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
                            correoDestino = user.getEmail();
                        } else {
                            System.out.print("Ingrese su correo electrónico para recibir la boleta: ");
                            correoDestino = scanner.nextLine();
                        }

                        System.out.println("Procesando pago...");
                        System.out.println("Pago realizado con éxito mediante " + (metodoPago.equals("1") ? "débito" : "crédito"));
                        System.out.println("Boleta enviada a: " + correoDestino);
                        System.out.println("Total pagado: $" + orderController.getTotalAfterDiscount());
                        running = false;
                    } else if (metodoPago.equals("3")) {
                        System.out.println("Compra cancelada.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                    
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}