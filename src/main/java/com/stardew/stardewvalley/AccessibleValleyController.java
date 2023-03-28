package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.layout.*;

import java.util.ArrayList;

/**
 * Classe AccessibleValleyController permettant de gérer la classe de lancement du jeu (controleur MVC de la classe HelloApplication)
 *
 * @version le 22/03/2023
 */
public class AccessibleValleyController {

    private Clavier clavier;
    private ArrayList<Champ> listeChamps = new ArrayList<>();
    private ArrayList<Pierre> listePierres = new ArrayList<>();
    private ArrayList<Herbe> listeHerbes = new ArrayList<>();
    private ArrayList<Maison> listeMaison = new ArrayList<>();

    private ArrayList<Coffre> listeCoffre = new ArrayList<>();

    private Carte carte;

    @FXML
    BorderPane borderPanel;

    /**
     * Initialise la carte (taille et position sur l'écran, les objets sur la carte)
     */
    @FXML
    private void initialize() {

        if(clavier == null) {
            this.carte = new Carte();
            this.borderPanel.setMaxHeight(768);
            this.borderPanel.setMaxWidth(1366);
            this.borderPanel.setCenter(this.carte);
            this.clavier = new Clavier(this.carte);
            initializeChamps(this.carte);
            initializePierre(this.carte);
            initializeHerbes(this.carte);
            initializeMaison(this.carte);
            initializeCoffre(this.carte);
            this.borderPanel.setOnKeyPressed(this.clavier);
        }

    }

    /**
     * Positionne les champs sur la carte
     *
     * @param carte
     */
    private void initializeChamps(Carte carte) {

        int index = 0;

        // Premier champ
        for (int i = 0 ; i<8;i++) {
            for (int j = 0 ; j<6;j++){
                listeChamps.add(new Champ(j,3+i));

            }
        }

        // Deuxieme champ
        for (int i = 0 ; i<6;i++) {
            for (int j = 0 ; j<4;j++){
                listeChamps.add(new Champ(8+j,5+i));

            }
        }

        // Troisieme champ
        for (int i = 0 ; i<4;i++) {
            for (int j = 0 ; j<2;j++){
                listeChamps.add(new Champ(17+j,7+i));

            }
        }

        for(index=0 ; index< listeChamps.size() ; index++) {
            listeChamps.get(index).setFitWidth(carte.getCellWidth());
            listeChamps.get(index).setFitHeight(carte.getCellHeight());

            carte.add( listeChamps.get(index), listeChamps.get(index).getPosX(), listeChamps.get(index).getPosY());
        }

    }

    /**
     * Positionne les pierres sur la carte
     * 
     * @param carte
     */
    private void initializePierre(Carte carte) {

        int index = 0;

        //Premier champ
        for (int i = 0 ; i<4;i++){
                listePierres.add(new Pierre(6+i,0));
        }

        // Deuxième champ
        listePierres.add(new Pierre(7,6));
        listePierres.add(new Pierre(6,8));
        listePierres.add(new Pierre(6,5));
        listePierres.add(new Pierre(13,4));
        listePierres.add(new Pierre(13,7));
        listePierres.add(new Pierre(13,9));
        listePierres.add(new Pierre(15,6));
        listePierres.add(new Pierre(4,2));
        listePierres.add(new Pierre(5,2));

        for(index=0  ; index< listePierres.size();index++) {
            listePierres.get(index).setFitWidth(carte.getCellWidth());
            listePierres.get(index).setFitHeight(carte.getCellHeight());

            carte.add( listePierres.get(index),  listePierres.get(index).getPosX(),  listePierres.get(index).getPosY());
        }

    }

    /**
     * Positionne les herbes sur la carte
     * 
     * @param carte
     */
    private void initializeHerbes(Carte carte) {

        int index = 0;
        //Premier champ
        for (int i = 0 ; i<5;i++) {
            for (int j = 0 ; j<4;j++){
                if(i>0) {
                    if (j == 0 || j == 3) {
                        listeHerbes.add(new Herbe(16 + j, 6 + i));
                    }
                } else {
                    listeHerbes.add(new Herbe(16 + j, 6 + i));
                }

            }
        }

        for(index=0  ; index< listeHerbes.size();index++) {
            listeHerbes.get(index).setFitWidth(carte.getCellWidth());
            listeHerbes.get(index).setFitHeight(carte.getCellHeight());

            carte.add(listeHerbes.get(index), listeHerbes.get(index).getPosX(), listeHerbes.get(index).getPosY());
        }

    }

    /**
     * Positionne la maison sur la carte
     * 
     * @param carte
     */
    private void initializeMaison(Carte carte) {
        int index = 0;
        //Premier champ
        for (int i = 0 ; i<3;i++){
            for (int j = 0 ; j<3;j++){

                    if (i == 2 && j == 1) {
                        listeMaison.add(new Maison(18 + j, 0 + i,true,true));
                    }
                    else{
                        listeMaison.add(new Maison(18 + j, 0 + i,false,true));
                }

            }
        }

        for(index=0  ; index< listeMaison.size();index++){
            listeMaison.get(index).setFitWidth(carte.getCellWidth());
            listeMaison.get(index).setFitHeight(carte.getCellHeight());

            carte.add( listeMaison.get(index),  listeMaison.get(index).getPosX(),  listeMaison.get(index).getPosY());
        }
    }
    /**
     * Positionne le coffre sur la carte
     *
     * @param
     */

    private void initializeCoffre(Carte carte){
        int index =0;

        listeCoffre.add(new Coffre(17,2));

        for(index=0  ; index< listeCoffre.size();index++){
            listeCoffre.get(index).setFitWidth(carte.getCellWidth());
            listeCoffre.get(index).setFitHeight(carte.getCellHeight());

            carte.add( listeCoffre.get(index),  listeCoffre.get(index).getPosX(),  listeCoffre.get(index).getPosY());
        }
    }

}
