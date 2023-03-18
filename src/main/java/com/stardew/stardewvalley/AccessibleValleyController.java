package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccessibleValleyController {

    private Clavier clavier;
    private ArrayList<Champ> ListeChamps = new ArrayList<>();
    private ArrayList<Pierre> ListePierres = new ArrayList<>();
    private ArrayList<Herbe> ListeHerbes = new ArrayList<>();
    private Carte carte;

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
            initializeChamps(this.carte);
            initializePierre(this.carte);
            initializeHerbes(this.carte);


            //this.initialiserTabCarte();



           // carte.add(new Text("sidufhsdifh"),1,2);
            //carte.add(new Champ(5,5).getImage(),1,3);




            this.borderPanel.setOnKeyPressed(this.clavier);
            //  this.borderPanel.setTop(p.getImage());
            System.out.println("Clavier :"+this.clavier);


        }

    }

    private void initializeChamps(Carte carte){
        int index = 0;
        //Premier champ
        for (int i = 0 ; i<8;i++){
            for (int j = 0 ; j<6;j++){
                ListeChamps.add(new Champ(j,3+i));

            }
        }
        //Deuxieme champ
        for (int i = 0 ; i<6;i++){
            for (int j = 0 ; j<4;j++){
                ListeChamps.add(new Champ(8+j,5+i));

            }
        }

        //Troisieme champ
        for (int i = 0 ; i<4;i++){
            for (int j = 0 ; j<2;j++){
                ListeChamps.add(new Champ(17+j,7+i));

            }
        }
        for(index=0  ; index< ListeChamps.size();index++){
            ListeChamps.get(index).setFitWidth(carte.getCellWidth());
            ListeChamps.get(index).setFitHeight(carte.getCellHeight());

            carte.add( ListeChamps.get(index),  ListeChamps.get(index).getPosX(),  ListeChamps.get(index).getPosY());
        }

    }
    private void initializePierre(Carte carte){
        int index = 0;
        //Premier champ
        for (int i = 0 ; i<4;i++){
                ListePierres.add(new Pierre(6+i,0));
        }
        //Deuxieme champ

        ListePierres.add(new Pierre(7,6));
        ListePierres.add(new Pierre(6,8));
        ListePierres.add(new Pierre(6,5));
        ListePierres.add(new Pierre(13,4));
        ListePierres.add(new Pierre(13,7));
        ListePierres.add(new Pierre(13,9));
        ListePierres.add(new Pierre(15,6));
        ListePierres.add(new Pierre(4,2));
        ListePierres.add(new Pierre(5,2));



        for(index=0  ; index< ListePierres.size();index++){
            ListePierres.get(index).setFitWidth(carte.getCellWidth());
            ListePierres.get(index).setFitHeight(carte.getCellHeight());

            carte.add( ListePierres.get(index),  ListePierres.get(index).getPosX(),  ListePierres.get(index).getPosY());
        }

    }
    private void initializeHerbes(Carte carte){
        int index = 0;
        //Premier champ
        for (int i = 0 ; i<5;i++){
            for (int j = 0 ; j<4;j++){
                if(i>0) {
                    if (j == 0 || j == 3) {
                        ListeHerbes.add(new Herbe(16 + j, 6 + i));
                    }
                }else{
                    ListeHerbes.add(new Herbe(16 + j, 6 + i));
                }

            }
        }

        for(index=0  ; index< ListeHerbes.size();index++){
            ListeHerbes.get(index).setFitWidth(carte.getCellWidth());
            ListeHerbes.get(index).setFitHeight(carte.getCellHeight());

            carte.add( ListeHerbes.get(index),  ListeHerbes.get(index).getPosX(),  ListeHerbes.get(index).getPosY());
        }

    }

}
