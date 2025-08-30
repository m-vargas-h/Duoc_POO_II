/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.duoc.exp1_s3;

import com.duoc.exp1_s3.controller.*;
import com.duoc.exp1_s3.model.*;
import com.duoc.exp1_s3.view.*;

import java.util.Scanner;

/**
 *
 * @author mvarg
 */

public class Exp1_S3 {
    public static void main(String[] args) {
        // Usuario de prueba
        User user = new User("U001", "Miguel Vargas", "miguel@example.com", "Premium");

        // Controladores
        ProductController productController = new ProductController();
        OrderController orderController = new OrderController(user);
        UserController userController = new UserController(user);
        Invoker invoker = new Invoker();

        // Vistas
        ProductView productView = new ProductView(productController, user);
        CartView cartView = new CartView(orderController);
        DiscountView discountView = new DiscountView();

        // Configuración de descuentos
        DiscountManager dm = DiscountManager.getInstance();
        dm.setUserTypeDiscount("Premium", 15.0);
        dm.setUserTypeDiscount("Staff", 20.0);
        dm.setCategoryDiscount("Clothing", 10.0);
        dm.setCategoryDiscount("Shoes", 5.0);

        // Flujo básico
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Ver productos disponibles");
            System.out.println("2. Consultar precio con descuento");
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Aplicar descuentos al carrito");
            System.out.println("6. Ver descuentos configurados");
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
                    orderController.applyDiscounts(dm);
                    System.out.println("Descuentos aplicados al carrito.");
                    break;

                case "6":
                    discountView.showUserTypeDiscounts();
                    discountView.showCategoryDiscounts();
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