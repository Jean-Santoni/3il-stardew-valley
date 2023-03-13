package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class HelloController {

    @FXML
    BorderPane borderPanel;

    @FXML
    private void initialize() {
        this.borderPanel.setCenter(new Carte());
    }
}