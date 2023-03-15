package com.stardew.stardewvalley;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Carte extends GridPane {

    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 10;
    private Image fondCarte = new Image("file:Images/Map.jpg");

    private Personnage personnage;

    public Carte() {
        super();
        this.setOnKeyPressed(new Clavier(this));
        initialiserCarte();
        this.personnage = new Personnage();
        this.add(this.personnage,0,0);
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
            column.setMaxWidth(1366/(MAX_WIDTH+1));
            column.setMinWidth(1366/(MAX_WIDTH+1));
            this.getColumnConstraints().add(column);
        }
        for (int r = 0; r <= MAX_HEIGHT; r++) {
            RowConstraints row = new RowConstraints();
            //row.setPercentHeight(100.0 / 4);
            row.setMaxHeight(768/(MAX_HEIGHT+1));
            row.setMinHeight(768/(MAX_HEIGHT+1));
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


    public void deplacerJoueur(int i, int i1) {
        if(joueurDeplacable(this.personnage.getPosY() +i,this.personnage.getPosX() + i1)){
            this.getChildren().remove(this.personnage);
            this.personnage.setPosX(this.personnage.getPosX() +i1);
            this.personnage.setPosY(this.personnage.getPosY() +i);
            this.add(this.personnage,this.personnage.getPosX(),this.personnage.getPosY());
        }
    }

    private boolean joueurDeplacable(int i, int i1) {
        if(i<0||i1<0||i>MAX_HEIGHT||i1>MAX_WIDTH){
            return false;
        }
        if(getNodeByRowColumnIndex(i,i1) != null){
            if(((ObjetInteractif)getNodeByRowColumnIndex(i,i1)).getEstMarchable()){
                return true;
            }
            return false;
        }
        return true;
    }
    public Node getNodeByRowColumnIndex (final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = this.getChildren();

        for (Node node : childrens) {
            if(this.getRowIndex(node) != null&& this.getColumnIndex(node) != null){
                if(this.getRowIndex(node) == row && this.getColumnIndex(node) == column) {
                    result = node;
                    break;
                }
            }
        }
        return result;
    }
}