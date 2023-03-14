package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class AccessibleValleyController {


    @FXML
    BorderPane borderPanel;

    @FXML
    private void initialize() throws FileNotFoundException {
        Carte carte = new Carte();
        carte.add(new Text("sidufhsdifh"),1,2);
        //carte.add(new Champ(5,5).getImage(),1,3);


        // Pierre p = new Pierre(50,20);
        this.borderPanel.setCenter(carte);
      //  this.borderPanel.setTop(p.getImage());

    }
}
