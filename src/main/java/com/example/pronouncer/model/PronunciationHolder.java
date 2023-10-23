package com.example.pronouncer.model;

import javafx.scene.media.Media;

public class PronunciationHolder {
    private Browser browser;
    private final PronunciationHolderModel model;

    public PronunciationHolder(PronunciationHolderModel model, Browser browser){
        this.browser = browser;
        this.model = model;
    }

    public void setEngine(Browser browser){
        this.browser = browser;
    }

    public Media getSound(String word)
    {
        return browser.getSound(word, model);
    }
}
