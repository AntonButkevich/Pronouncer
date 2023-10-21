package com.example.pronouncer.scene;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import javafx.scene.Parent;

public class Scene extends javafx.scene.Scene {
    private final KeyboardEventHandler keyboardEventHandler;

    public Scene(Parent parent, double v, double v1) {
        super(parent, v, v1);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            throw new RuntimeException(e);
        }

        GlobalScreen.addNativeKeyListener(keyboardEventHandler = new KeyboardEventHandler());
    }

    // TODO take a look at the NativeKeyEvent
    public void addKeyStrokeListener(KeyStroke keyStroke, KeyStrokeListener listener){
        keyboardEventHandler.addKeyStrokeListener(keyStroke, listener);
    }

    public void removeKeyStrokeListener(KeyStrokeListener listener){
        keyboardEventHandler.removeKeyStrokeListener(listener);
    }
}
