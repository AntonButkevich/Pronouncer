package com.example.pronouncer.model;

import javafx.scene.media.Media;

public class GoogleBrowser extends Browser {
    public GoogleBrowser(Pronunciation pronunciation) {
        super(pronunciation);
    }

    @Override
    Media getSound(String word, PronunciationHolderModel model) {
        return null;
    }

    @Override
    public String toString()
    {
        return "Google";
    }
}
