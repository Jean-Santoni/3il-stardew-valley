package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class AccessibleValleyController {

    private Clavier clavier;
    private Carte carte;
    private Node[][] tabCarte = null;

    @FXML
    BorderPane borderPanel;

    @FXML
    private void initialize() throws FileNotFoundException {
        if(clavier == null){
            this.carte = new Carte();
            this.borderPanel.setMaxHeight(768);
            this.borderPanel.setMaxWidth(1366);
            this.borderPanel.setCenter(this.carte);
            this.clavier = new Clavier(this.carte);
            this.initialiserTabCarte();



            carte.add(new Text("sidufhsdifh"),1,2);
            //carte.add(new Champ(5,5).getImage(),1,3);


            // Pierre p = new Pierre(50,20);

            this.borderPanel.setOnKeyPressed(this.clavier);
            //  this.borderPanel.setTop(p.getImage());
            System.out.println("Clavier :"+this.clavier);

        }

    }

    private void initialiserTabCarte() {

        tabCarte = new Node[carte.getMAX_WIDTH()][carte.getMAX_HEIGHT()];

        for(Node node : this.borderPanel.getChildren()) {
            if(node != null) {
                if(carte.getRowIndex(node) != null && carte.getColumnIndex(node) != null) {
                    this.tabCarte[carte.getRowIndex(node)][carte.getColumnIndex(node)] = node;
                }
            }

        }

    }

}
