package com.example.pronouncer.scene;

import java.util.Arrays;

public class KeyStroke {
    final Key[] keys;

    public KeyStroke(Key ...keys) {
        this.keys = keys;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        KeyStroke keyStroke = (KeyStroke) object;
        if (keys.length != keyStroke.keys.length) return false;
        for (int i = 0; i < keys.length; i++)
            if (keys[i] != keyStroke.keys[i])
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keys);
    }
}
