/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s3.controller;

import com.duoc.exp1_s3.model.Command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mvarg
 */

public class Invoker {

    private List<Command> commandHistory; // Historial de comandos ejecutados

    // Constructor
    public Invoker() {
        this.commandHistory = new ArrayList<>();
    }

    // Ejecuta un comando y lo guarda en el historial
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
        System.out.println("Comando ejecutado correctamente.");
    }

    // Muestra el historial de comandos
    public void showHistory() {
        System.out.println("Historial de comandos ejecutados: " + commandHistory.size());
    }

    // Limpia el historial de comandos
    public void clearHistory() {
        commandHistory.clear();
        System.out.println("Historial de comandos borrado.");
    }
}
