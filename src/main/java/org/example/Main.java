package org.example;

import org.example.controllers.KeyboardControl;
import org.example.enums.Command;
import org.example.ui.UI;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        KeyboardControl keyboardControl = new KeyboardControl();

        boolean running = true;
        boolean autoClicking = false;

        System.out.println("Aguardando comandos do teclado...");
        UI.showCommands();

        while (running) {
            Command command = keyboardControl.getCommand();

            if (command != null) {
                switch (command) {
                    case CONFIG -> System.out.println("Entrando no modo de configuração...");
                    case END_CONFIG -> System.out.println("Finalizando o modo de configuração...");
                    case START -> {
                        autoClicking = true;
                        System.out.println("Iniciando os autocliques...");
                    }
                    case STOP -> {
                        autoClicking = false;
                        System.out.println("Pausando os autocliques...");
                    }
                    case EXIT -> {
                        running = false;
                        System.out.println("Saindo do programa...");
                        keyboardControl.shutdown(); // Remove o hook global
                    }
                }

                keyboardControl.clearCommand();
            }
        }

        /*List<Coordinate> path = List.of(
                //Coordinate.of(2014, 154),
                Coordinate.of(3005, 406)
        );

        MyRobot robot = new MyRobot();
        robot.setPath(path);

        Color duelPickerColor = Color.decode("0xA83DB4");

        while (true) {
            robot.getPath().forEach(pos -> {
                robot.checkDuel(duelPickerColor);
                robot.doubleClick(pos);
            });

            Thread.sleep(2000);
        }*/
    }
}