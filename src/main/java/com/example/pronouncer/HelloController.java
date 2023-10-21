package com.example.pronouncer;

import com.example.pronouncer.model.PronunciationSupplier;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class HelloController {
    @FXML
    private ListView<PronunciationSupplier> pronunciationSuppliers;

    public void addItemToListView(PronunciationSupplier pronunciationSupplier){
        pronunciationSuppliers.getItems().add(pronunciationSupplier);
    }
}