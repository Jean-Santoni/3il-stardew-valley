package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.FileNotFoundException;

public class MaisonController {
    private Clavier clavier;
    private MaisonInterieur maison;
    @FXML
    private BorderPane interieur;
    @FXML
    private void initialize()  {
        if(clavier == null){
            this.maison = new MaisonInterieur();
            this.interieur.setMaxHeight(768);
            this.interieur.setMaxWidth(1366);
            this.interieur.setCenter(this.maison);
            this.clavier = new Clavier(this.maison);
            this.interieur.setOnKeyPressed(this.clavier);
            System.out.println("Clavier :"+this.clavier);
        }

    }
}
