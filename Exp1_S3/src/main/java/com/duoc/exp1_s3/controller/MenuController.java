
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.*;
import com.duoc.exp1_s3.view.*;

import java.util.Scanner;

public class MenuController {

    private final ProductController productController;  // Controlador de productos
    private final OrderController orderController;      // Controlador de órdenes
    private final UserController userController;        // Controlador de usuarios
    private final Invoker invoker;                      // Invocador para comandos
    private final DiscountManager discountManager;      // Gestor de descuentos
    private final ProductView productView;              // Vista de productos
    private final CartView cartView;                    // Vista del carrito
    private final DiscountView discountView;            // Vista de descuentos
    private final Scanner scanner;                      // Scanner para entrada de usuario

    // Constructor
    public MenuController(User user) {
        this.productController = new ProductController();
        this.orderController = new OrderController(user);
        this.userController = new UserController();
        this.userController.setCurrentUser(user);
        this.invoker = new Invoker();
        this.discountManager = DiscountManager.getInstance();
        this.productView = new ProductView(productController, user);
        this.cartView = new CartView(orderController);
        this.discountView = new DiscountView();
        this.scanner = new Scanner(System.in);

        discountManager.setUserTypeDiscount("VIP", 15.0);
        discountManager.setUserTypeDiscount("Staff", 20.0);
        discountManager.setCategoryDiscount("Ropa", 10.0);
        discountManager.setCategoryDiscount("Calzado", 5.0);
    }

    // Método para mostrar el menú y manejar las opciones del usuario
    public void mostrarMenu() {
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
                case "1":       // Ver productos disponibles
                    productView.showAvailableProducts();
                    break;

                case "2":       // Consultar precio con descuento
                    productView.showDiscountedProduct();
                    break;

                case "3":       // Agregar producto al carrito
                    System.out.print("Ingrese ID del producto: ");
                    String productId = scanner.nextLine();
                    System.out.print("Ingrese cantidad: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    Command addCommand = new AddToCartCommand(productController, orderController, 
                                                                productId, quantity);
                    invoker.executeCommand(addCommand);
                    break;

                case "4":       // Ver carrito
                    cartView.showCartContents();
                    break;

                case "5":       // Ver descuentos configurados
                    discountView.showUserTypeDiscounts();
                    discountView.showCategoryDiscounts();
                    break;

                case "6":       // Ver información del usuario
                    userController.showUserInfo();
                    break;

                case "7":       // Proceder al pago    
                    PaymentProcessor.procesarPago(orderController, userController.getCurrentUser(), 
                                                    discountManager, scanner);
                    running = false;
                    break;

                case "0":       // Salir
                    running = false;
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:        // Opción inválida
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}