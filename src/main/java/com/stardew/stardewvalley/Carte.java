package com.stardew.stardewvalley;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

public class Carte extends GridPane {

    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 10;
    private KeyEvent deplacementPrecedent;
    private Image fondCarte = new Image("file:Images/RPG-Maper.png");

    private Personnage personnage;

    public Carte() {
        super();
        this.setOnKeyPressed(new Clavier(this));
        initialiserCarte();
        this.personnage = new Personnage();
        //this.personnage.setFitHeight(100);
        //this.personnage.setFitWidth(70);
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

    }

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
        boolean result = true;
        if(i<0||i1<0||i>MAX_HEIGHT||i1>MAX_WIDTH){
            result = false;
        }
        if(getNodeByRowColumnIndex(i,i1) != null){
            if(((ObjetInteractif)getNodeByRowColumnIndex(i,i1)).getEstMarchable()){

                result = true;
            }else{
            result = false;}
        }
        return result ;
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

    public double getCellWidth() {
        return 1366/(MAX_WIDTH+1);
    }

    public double getCellHeight() {
        return 768/(MAX_HEIGHT+1);
    }
    public void setDeplacementPrecedent(KeyEvent k){
        this.deplacementPrecedent=k;
    }

    public void interagir(){
        int Xobjet=0;
        int Yobjet=0;
        switch (this.deplacementPrecedent.getCode()) {
            case RIGHT:
                //Personnage.deplacerX(1);
                Xobjet=this.personnage.getPosX()+1;
                Yobjet=this.personnage.getPosY();
                break;
            case LEFT:
                //Personnage.deplacerX(-1);
                Xobjet=this.personnage.getPosX()-1;
                Yobjet=this.personnage.getPosY();
                break;
            case UP:
                //Personnage.deplacerY(1);
                Xobjet=this.personnage.getPosX();
                Yobjet=this.personnage.getPosY()-1;
                break;
            case DOWN:
                //Personnage.deplacerY(-1);
                Xobjet=this.personnage.getPosX();
                Yobjet=this.personnage.getPosY()+1;
                break;
            default:
                break;
        }
        if(this.getNodeByRowColumnIndex(Yobjet,Xobjet) != null){
           ObjetInteractif objet= (ObjetInteractif) getNodeByRowColumnIndex(Yobjet,Xobjet);
           objet.interraction();

        }

    }
}