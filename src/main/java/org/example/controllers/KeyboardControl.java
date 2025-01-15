package org.example.controllers;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import org.example.enums.ProgramStatus;

public class KeyboardControl implements NativeKeyListener {
    private ProgramStatus userCommand;

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
                case NativeKeyEvent.VC_J -> this.userCommand = ProgramStatus.CONFIGURING;      // ALT + J
                case NativeKeyEvent.VC_R -> this.userCommand = ProgramStatus.RUNNING;       // ALT + R
                case NativeKeyEvent.VC_P -> this.userCommand = ProgramStatus.PAUSED;        // ALT + P
            }
        } else if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            this.userCommand = ProgramStatus.EXITING; // ESC
        }
    }

    public ProgramStatus getUserCommand() {
        return this.userCommand;
    }

    public void clearCommand() {
        this.userCommand = null;
    }

    public void shutdown() {

        try {
            GlobalScreen.unregisterNativeHook();
        } catch (Exception e) {
            System.err.println("Erro ao remover o hook do teclado: " + e.getMessage());
        }
    }
}
