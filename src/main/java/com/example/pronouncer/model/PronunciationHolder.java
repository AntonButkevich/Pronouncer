package com.example.pronouncer.model;

import javafx.scene.media.Media;

public class PronunciationHolder {
    private PronunciationSupplier pronunciationSupplier;
    private final PronunciationHolderModel model;

    public PronunciationHolder(PronunciationHolderModel model, PronunciationSupplier pronunciationSupplier){
        this.pronunciationSupplier = pronunciationSupplier;
        this.model = model;
    }

    public void setEngine(PronunciationSupplier pronunciationSupplier){
        this.pronunciationSupplier = pronunciationSupplier;
    }

    public Media getSound(String word)
    {
        return pronunciationSupplier.getSound(word, model);
    }
}
