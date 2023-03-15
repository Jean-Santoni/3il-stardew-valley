package com.stardew.stardewvalley;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Carte extends GridPane {

    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 10;
    private Image fondCarte = new Image("file:Images/Map.jpg");

    public Carte() {
        super();
        initialiserCarte();
        this.add(new Personnage(),0,0);
        this.setBackground(new Background(new BackgroundImage(fondCarte,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,
                        true, true,true, true))));
        //adapterObjets();
    }

    private void initialiserCarte() {
        this.getColumnConstraints().clear();
        this.getRowConstraints().clear();
        for (int c = 0; c <= MAX_WIDTH; c++) {
            ColumnConstraints column = new ColumnConstraints();
            //column.setPercentWidth(100.0 / 2);
            column.setMaxWidth(fondCarte.getWidth()/MAX_WIDTH);
            column.setMinWidth(fondCarte.getWidth()/MAX_WIDTH);
            this.getColumnConstraints().add(column);
        }
        for (int r = 0; r <= MAX_HEIGHT; r++) {
            RowConstraints row = new RowConstraints();
            //row.setPercentHeight(100.0 / 4);
            row.setMaxHeight(fondCarte.getHeight()/MAX_HEIGHT);
            row.setMinHeight(fondCarte.getHeight()/MAX_HEIGHT);
            this.getRowConstraints().add(row);
        }
        this.setGridLinesVisible(true);
       /* int collIndex = 0;
        int rowIndex = 0;
        int listeIndex = 0;
        for (collIndex = 0; collIndex <= 2; collIndex++) {
            for (rowIndex = 0; rowIndex <= 3; rowIndex++) {
                ImageView n = new ImageView();
                if(ListeCarte.get(listeIndex).isClique()==false) {
                    n.setImage(ListeCarte.get(listeIndex).getDos());
                }else if(ListeCarte.get(listeIndex).isValide() && ListeCarte.get(listeIndex).isClique() ){
                    n.setImage(ListeCarte.get(listeIndex).getValide());
                }else {
                    n.setImage(ListeCarte.get(listeIndex).getFace());
                }
                n.setFitWidth(100.0);
                n.setFitHeight(100.0);
                Carte carteTampon = ListeCarte.get(listeIndex);
                n.setOnMouseClicked(event ->CliqueCase(carteTampon) );
                this.add(n, collIndex, rowIndex);
                listeIndex++;
            }
        }
        listeIndex=0;*/
    }/*
    private void adapterObjets(){
        for (int i = 0 ;i<this.getRowCount();i++){
            for (int y = 0 ;y<this.getRowCount();y++){
                for (Node objet: this.getChildren()) {
                    objet.maxHeight(fondCarte.getHeight()/MAX_HEIGHT);
                    objet.maxWidth(fondCarte.getWidth()/MAX_WIDTH);
                }
            }

        }
    }*/

    public int getMAX_WIDTH() {
        return this.MAX_WIDTH;
    }

    public int getMAX_HEIGHT() {
        return this.MAX_HEIGHT;
    }


}