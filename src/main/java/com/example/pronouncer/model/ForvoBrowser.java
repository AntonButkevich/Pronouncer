package com.example.pronouncer.model;

import javafx.scene.media.Media;

public class ForvoBrowser extends Browser
{
    public ForvoBrowser(Pronunciation pronunciation) {
        super(pronunciation);
    }

    @Override
    Media getSound(String word, PronunciationHolderModel model) {
        return null;
    }

    @Override
    public String toString()
    {
        return "Forvo";
    }
}
