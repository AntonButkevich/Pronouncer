package com.example.pronouncer.model;

import javafx.scene.media.Media;

public abstract class PronunciationSupplier {
    private final Pronunciation pronunciation;
    PronunciationSupplier(Pronunciation pronunciation){
        this.pronunciation = pronunciation;
    }
    abstract Media getSound(String word, PronunciationHolderModel model);
}
