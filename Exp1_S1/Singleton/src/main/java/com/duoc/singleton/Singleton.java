
package com.duoc.singleton;

import java.util.Scanner;

public class Singleton {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Polera Básica", 12000),
            new Product("Chaqueta Denim", 18000),
            new Product("Pantalón Cargo", 9500)
        };

        Scanner scanner = new Scanner(System.in);
        DiscountManager manager = DiscountManager.getInstance();

        System.out.println("------------ Lista de Productos ------------");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s - $%.2f\n", i + 1, products[i].getName(), 
                    products[i].getPrice());
        }

        System.out.print("\nSelecciona el número del producto: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= products.length) {
            System.out.println("Producto no válido.");
            return;
        }

        System.out.print("Ingresa la cantidad que deseas comprar: ");
        int quantity = scanner.nextInt();

        Product selected = products[index];
        double unitPrice = selected.getPrice();
        double totalPrice = unitPrice * quantity;
        double discountPercentage = manager.calculateDiscountPercentage(quantity);
        double discountAmount = totalPrice * discountPercentage / 100;
        double finalPrice = totalPrice - discountAmount;

        System.out.println("\n----------- Detalle de Compra ------------");
        System.out.printf("%-30s %10s %n", "Precio total sin descuento:", "$" + 
                        (int) totalPrice);
        System.out.printf("%-30s %10s %n", "Descuento aplicado (" + (int) discountPercentage + 
                        "%):", "$" + (int) discountAmount);
        System.out.printf("%-30s %10s %n", "Precio final con descuento:", "$" + 
                        (int) finalPrice);
        System.out.println("------------------------------------------");

        scanner.close();
    }
}