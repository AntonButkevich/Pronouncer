package com.example.pronouncer.scene;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardEventHandler implements NativeKeyListener {
    private final Map<KeyStroke, List<KeyStrokeListener>> keyStrokeListeners;
    private final List<Key> pressedKeys;
    private final Map<Integer, Key> codesMap;

    public KeyboardEventHandler()
    {
        this.keyStrokeListeners = new HashMap<>();
        this.pressedKeys = new ArrayList<>();
        this.codesMap = new HashMap<>();

        this.codesMap.put(46, Key.C);
        this.codesMap.put(56, Key.OPTION);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        pressedKeys.add(codesMap.getOrDefault(nativeEvent.getKeyCode(), Key.UNDEFINED));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        if (!keyStrokeListeners.isEmpty()){
            KeyStroke keyStroke = new KeyStroke(pressedKeys.toArray(new Key[]{}));
            if (keyStrokeListeners.get(keyStroke) != null){
                keyStrokeListeners.get(keyStroke).forEach(listener -> {
                    try {
                        listener.onKeyStrokeOccur(keyStroke);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        pressedKeys.clear();
    }

    public void addKeyStrokeListener(KeyStroke keyStroke, KeyStrokeListener listener){
        keyStrokeListeners.computeIfAbsent(keyStroke, k -> new ArrayList<>());
        keyStrokeListeners.get(keyStroke).add(listener);
    }

    public void removeKeyStrokeListener(KeyStrokeListener listener){
        for (Map.Entry<KeyStroke, List<KeyStrokeListener>> e : keyStrokeListeners.entrySet()){
            if (e.getValue() == null)
                continue;

            if (e.getValue().removeIf(iteratingListener -> iteratingListener == listener))
                return;
        }
    }
}
