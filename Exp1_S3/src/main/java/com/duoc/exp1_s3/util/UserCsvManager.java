package com.duoc.exp1_s3.util;

import com.duoc.exp1_s3.model.User;

import java.io.*;
import java.util.*;

public class UserCsvManager {

    private static final String FOLDER_PATH = "Exp1_S3/data";           // Carpeta para almacenar datos
    private static final String FILE_PATH = FOLDER_PATH + "/users.csv"; // Archivo CSV

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_PATH);

        // Si el archivo no existe, retornar lista vacía
        if (!file.exists()) {
            System.out.println("Archivo de usuarios no encontrado. Se creará uno nuevo.");
            createDataFolder();

            //?[DEBUG]: Imprimir ruta absoluta del archivo creado
            //System.out.println("Archivo guardado en: " + new File(FILE_PATH).getAbsolutePath());
            return users;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String userType = parts[3].trim();
                    users.add(new User(id, name, email, userType));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
        }

        return users;
    }

    public static void saveUser(User user) {
        createDataFolder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getUserType());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario en el archivo.");
        }
    }

    private static void createDataFolder() {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
}