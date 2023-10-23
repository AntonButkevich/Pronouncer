package com.example.pronouncer.model;

import javafx.scene.media.Media;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CambridgeBrowser extends Browser {
    public CambridgeBrowser(Pronunciation pronunciation) {
        super(pronunciation);
    }

    @Override
    Media getSound(String word, PronunciationHolderModel model) {
        if (word.split(" ").length > 1)
            return null;

        Document doc;
        try {
            doc = Jsoup.connect("https://dictionary.cambridge.org/pronunciation/english/"+word).get();
        } catch (IOException e) {
            return null;
        }

        Elements elements = doc.getElementsByAttributeValue("class", "pron-block lmb-10");
        if (elements.isEmpty())
            return null;

        // TODO save region code in Pronunciation
        elements = elements.get(0).getElementsByAttributeValue("data-pron-region", "US");

        if (elements.isEmpty())
            return null;

        elements = elements.get(0).getElementsByAttributeValue("type", "audio/mpeg");
        if (elements.isEmpty())
            return null;

        Element element = elements.get(0);
        String src = "https://dictionary.cambridge.org" + element.attr("src");

        return null;
    }

    @Override
    public String toString()
    {
        return "Cambridge";
    }
}
