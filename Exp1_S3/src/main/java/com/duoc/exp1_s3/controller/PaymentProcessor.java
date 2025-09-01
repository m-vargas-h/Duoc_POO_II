package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.*;

import java.util.Scanner;

public class PaymentProcessor {

    public static void procesarPago(OrderController orderController, User user, DiscountManager dm, 
                                    Scanner scanner) {

        // Verificar si el carrito está vacío                                
        if (orderController.isEmpty()) {
            System.out.println("El carrito está vacío. No se puede proceder al pago.");
            return;
        }

        orderController.applyDiscounts(dm);

        System.out.println("----- Resumen de la compra -----");
        System.out.println("Cantidad de productos: " + orderController.getOrder().getProducts().size());
        System.out.println("Total sin descuento: $" + orderController.getTotalBeforeDiscount());
        System.out.println("Total con descuento: $" + orderController.getTotalAfterDiscount());

        System.out.println("\n----- Menú de pago -----");
        System.out.println("1. Pagar con débito");
        System.out.println("2. Pagar con crédito");
        System.out.println("3. Cancelar compra");
        System.out.print("Seleccione una opción: ");
        String metodoPago = scanner.nextLine();

        if (metodoPago.equals("1") || metodoPago.equals("2")) {
            String correoDestino = user.getEmail();
            if (correoDestino == null || correoDestino.isEmpty()) {
                System.out.print("Ingrese su correo electrónico para recibir la boleta: ");
                correoDestino = scanner.nextLine();
            }

            System.out.println("Procesando pago...");
            System.out.println("Pago realizado con éxito mediante " + (metodoPago.equals("1") ? "débito" : "crédito"));
            System.out.println("Boleta enviada a: " + correoDestino);
            System.out.println("Total pagado: $" + orderController.getTotalAfterDiscount());
        } else if (metodoPago.equals("3")) {
            System.out.println("Compra cancelada.");
        } else {
            System.out.println("Opción inválida.");
        }
    }
}