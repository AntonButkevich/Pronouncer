package com.example.pronouncer.scene;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface KeyStrokeListener {
    void onKeyStrokeOccur(KeyStroke keyStroke) throws IOException;
}
