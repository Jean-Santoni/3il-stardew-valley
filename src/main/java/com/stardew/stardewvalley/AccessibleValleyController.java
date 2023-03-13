package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class AccessibleValleyController {

    @FXML
    BorderPane borderPanel;

    @FXML
    private void initialize() {
        this.borderPanel.setCenter(new Carte());
    }
}
