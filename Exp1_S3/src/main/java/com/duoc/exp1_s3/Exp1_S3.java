/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.duoc.exp1_s3;

import com.duoc.exp1_s3.controller.*;
import com.duoc.exp1_s3.model.User;

public class Exp1_S3 {
    public static void main(String[] args) {
        UserController userController = new UserController();
        SessionManager sessionManager = new SessionManager(userController);
        User user = sessionManager.iniciarSesion();

        if (user != null) {
            MenuController menuController = new MenuController(user);
            menuController.mostrarMenu();
        }
    }
}