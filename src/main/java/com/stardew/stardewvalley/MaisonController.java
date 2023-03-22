package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe MaisonController permettant de gérer la Maison (Controleur MVC de la classe Maisson)
 *
 * @since le 22/03/20223
 * @version le 22/03/2023
 */
public class MaisonController {

    private Clavier clavier;
    private MaisonInterieur maison;
    private ArrayList<Maison> listeMaison = new ArrayList<>();

    @FXML
    private BorderPane interieur;

    /**
     * Initialise la Maison, la hauteur, la largeur, la position
     */
    @FXML
    private void initialize()  {
        if(clavier == null){
            this.maison = new MaisonInterieur();
            this.interieur.setMaxHeight(768);
            this.interieur.setMaxWidth(1366);
            this.interieur.setCenter(this.maison);
            initializeMaison(this.maison);
            this.clavier = new Clavier(this.maison);
            this.interieur.setOnKeyPressed(this.clavier);
            System.out.println("Clavier :"+this.clavier);
        }

    }
    private void initializeMaison(MaisonInterieur m) {
        int index = 0;
        //Premier champ
        for (int i = 0 ; i<9;i++){
            for (int j = 0 ; j<9;j++){

                if (i==2||i==8 || j==0||j==8) {
                    if(i==8 && j==2){
                    listeMaison.add(new Maison(6 + j, 1 + i,true,false));
                    }else{
                        listeMaison.add(new Maison(6 + j, 1 + i,false,false));
                    }

                }
            }
        }

        for(index=0  ; index< listeMaison.size();index++){
            listeMaison.get(index).setFitWidth(m.getCellWidth());
            listeMaison.get(index).setFitHeight(m.getCellHeight());


            m.add( listeMaison.get(index),  listeMaison.get(index).getPosX(),  listeMaison.get(index).getPosY());
        }
    }
}
