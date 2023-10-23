package com.example.pronouncer;

import com.example.pronouncer.model.Browser;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class HelloController {
    @FXML
    private ListView<Browser> pronunciationSuppliers;

    public void addItemToListView(Browser browser){
        pronunciationSuppliers.getItems().add(browser);
    }
}