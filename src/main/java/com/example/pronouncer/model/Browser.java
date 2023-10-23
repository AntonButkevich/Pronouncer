package com.example.pronouncer.model;

import javafx.scene.media.Media;

public abstract class Browser {
    protected final Pronunciation pronunciation;
    Browser(Pronunciation pronunciation){
        this.pronunciation = pronunciation;
    }
    abstract Media getSound(String word, PronunciationHolderModel model);
}
