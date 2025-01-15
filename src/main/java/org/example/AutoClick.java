package org.example;

import org.example.controllers.KeyboardControl;
import org.example.enums.ProgramStatus;
import org.example.ui.UI;

public class AutoClick {
    public static void run() {
        KeyboardControl keyboardControl = new KeyboardControl();

        UI.showCommands();

        boolean running = true;
        boolean autoClicking = false;

        while (running) {
            ProgramStatus programStatus = keyboardControl.getUserCommand();

            if (programStatus != null) {
                switch (programStatus) {
                    case CONFIGURING -> System.out.println("Entrando no modo de configuração...");
                    case RUNNING -> {
                        autoClicking = true;
                        System.out.println("Iniciando os autocliques...");
                    }
                    case PAUSED -> {
                        autoClicking = false;
                        System.out.println("Pausando os autocliques...");
                    }
                    case EXITING -> {
                        running = false;
                        System.out.println("Saindo do programa...");
                        keyboardControl.shutdown(); // Remove o hook global
                    }
                }

                keyboardControl.clearCommand();
            }
        }
    }
}
