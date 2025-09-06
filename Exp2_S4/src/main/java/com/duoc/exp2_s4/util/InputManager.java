package com.duoc.exp2_s4.util;

import java.util.Scanner;

/**
 * Clase encargada de gestionar la entrada del usuario desde consola.
 * Proporciona métodos seguros para capturar distintos tipos de datos.
 */
public class InputManager {
    private final Scanner scanner;

    /**
     * Constructor que inicializa el lector de entrada.
     */
    public InputManager() {
        scanner = new Scanner(System.in);
    }

    /**
     * Solicita una cadena de texto al usuario.
     *
     * @param mensaje Mensaje que se muestra antes de la entrada
     * @return Cadena ingresada
     */
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    /**
     * Solicita un número entero al usuario, validando la entrada.
     *
     * @param mensaje Mensaje que se muestra antes de la entrada
     * @return Número entero ingresado
     */
    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }
    }

    /**
     * Solicita un número decimal al usuario, validando la entrada.
     *
     * @param mensaje Mensaje que se muestra antes de la entrada
     * @return Número decimal ingresado
     */
    public double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número decimal.");
            }
        }
    }
}