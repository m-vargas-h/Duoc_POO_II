/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.exp1_s2.command;

/**
 *
 * @author mvarg
 */

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> comandos = new ArrayList<>();

    public void agregarComando(Command comando) {
        comandos.add(comando);
    }

    public void ejecutarComandos() {
        for (Command c : comandos) {
            c.ejecutar();
        }
        comandos.clear();
    }
}