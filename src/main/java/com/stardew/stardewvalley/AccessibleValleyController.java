package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class AccessibleValleyController {

    private Carte carte;
    private Node[][] tabCarte = null;

    @FXML
    BorderPane borderPanel;

    @FXML
    private void initialize() throws FileNotFoundException {

        this.carte = new Carte();
        this.borderPanel.setCenter(carte);

        this.initialiserTabCarte();

        carte.add(new Text("sidufhsdifh"),1,2);

        Pierre pierre = new Pierre(3,2);
        carte.add(pierre, pierre.getPosX(), pierre.getPosY());

        Herbe herbe = new Herbe(2, 1);
        carte.add(herbe, herbe.getPosX(), herbe.getPosY());

        Node herbe1 = this.tabCarte[2][1];

        if(herbe1 instanceof Herbe) {
            System.out.println("oui");
        }





      //  this.borderPanel.setTop(p.getImage());

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
