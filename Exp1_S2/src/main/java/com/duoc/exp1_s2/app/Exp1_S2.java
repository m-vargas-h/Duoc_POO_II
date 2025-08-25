/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.duoc.exp1_s2.app;

/**
 *
 * @author mvarg
 */

import com.duoc.exp1_s2.decorator.*;
import com.duoc.exp1_s2.singleton.DiscountManager;
import com.duoc.exp1_s2.command.*;

import java.util.List;
import java.util.Scanner;

public class Exp1_S2 {
    public static void main(String[] args) {
        // Definición de productos
        List<Product> productos = List.of(
            new Product("Chaqueta impermeable", 45000, 1, "Outdoor"),
            new Product("Mochila trekking", 38000, 1, "Outdoor"),
            new Product("Polera básica", 12000, 1, "Ropa"),
            new Product("Pantalón cargo", 18000, 1, "Ropa"),
            new Product("Zapatillas urbanas", 32000, 1, "Calzado"),
            new Product("Botines cuero", 49000, 1, "Calzado")
        );

        Scanner scanner = new Scanner(System.in);
        ShoppingCart carrito = new ShoppingCart();
        Invoker invoker = new Invoker();

        // Bucle principal de la aplicación
        while (true) {
            System.out.println("\n------ Catálogo ------");
            for (int i = 0; i < productos.size(); i++) {
                Product p = productos.get(i);
                System.out.printf("%d) %s - $%.0f [%s]\n", i + 1, p.getNombre(), p.getPrecioUnitario(), p.getCategoria());
            }
            System.out.println("0) Finalizar compra");

            System.out.print("Selecciona producto: ");
            int opcion = scanner.nextInt();
            if (opcion == 0) break;

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            Product base = productos.get(opcion - 1);
            Product productoFinal = new Product(base.getNombre(), base.getPrecioUnitario(), cantidad, base.getCategoria());

            // Aplicar decoradores de descuento, primero cantidad, luego categoría, para que se apliquen en ese orden
            Component decorado = new CategoryDiscountDecorator(
                new QuantityDiscountDecorator(productoFinal),
                productoFinal.getCategoria(),
                DiscountManager.getInstance().getDescuentoCategoria(productoFinal.getCategoria())
            );

            // Agregar al carrito usando Command
            invoker.agregarComando(new AddToCartCommand(carrito, decorado));
            invoker.ejecutarComandos();

            System.out.println("\nProducto agregado. Carrito:");
            carrito.mostrarCarrito();
        }

        System.out.println("\n------ Compra finalizada ------");
        carrito.mostrarCarrito();
    }
}