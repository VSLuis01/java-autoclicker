package org.example.controllers;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import org.example.enums.Command;

public class KeyboardControl implements NativeKeyListener {
    private Command command;

    public KeyboardControl() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
        } catch (Exception e) {
            System.err.println("Error registering native hook: " + e.getMessage());
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        int modifiers = e.getModifiers();

        // Verifica se o modificador ALT está pressionado
        if ((modifiers & NativeKeyEvent.ALT_MASK) != 0) {
            switch (e.getKeyCode()) {
                case NativeKeyEvent.VC_J -> this.command = Command.CONFIG;      // ALT + J
                case NativeKeyEvent.VC_A -> this.command = Command.END_CONFIG;  // ALT + A
                case NativeKeyEvent.VC_R -> this.command = Command.START;       // ALT + R
                case NativeKeyEvent.VC_P -> this.command = Command.STOP;        // ALT + P
            }
        } else if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            this.command = Command.EXIT; // ESC
        }
    }

    public Command getCommand() {
        return this.command;
    }

    public void clearCommand() {
        this.command = null;
    }

    public void shutdown() {

        try {
            GlobalScreen.unregisterNativeHook();
        } catch (Exception e) {
            System.err.println("Erro ao remover o hook do teclado: " + e.getMessage());
        }
    }
}
