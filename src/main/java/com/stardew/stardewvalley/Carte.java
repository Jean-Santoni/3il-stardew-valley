package com.stardew.stardewvalley;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import java.util.Optional;

/**
 * Classe Carte héritant d'une Grille
 * Contient les fonctions permettant de déplacer le joueur, initialiser la carte, interagir et quitter le jeu
 *
 * @version le 19/03/2023
 */
public class Carte extends GridPane {

    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 10;
    private KeyEvent deplacementPrecedent;
    private Image fondCarte = new Image("file:Images/RPG-Maper-Maison.png");

    private Personnage personnage;

    /**
     * Constructeur de Carte
     */
    public Carte() {

        super();

        this.setOnKeyPressed(new Clavier(this));
        initialiserCarte();
        this.personnage = new Personnage();
        this.personnage.setPreserveRatio(true);
        this.personnage.setFitHeight(100);
        this.add(this.personnage,0,0);
        this.setBackground(new Background(new BackgroundImage(fondCarte,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,
                        true, true,true, true))));
    }

    /**
     * Permet d'initialiser la Carte
     */
    private void initialiserCarte() {

        this.getColumnConstraints().clear();
        this.getRowConstraints().clear();

        for (int c = 0; c <= MAX_WIDTH; c++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMaxWidth(1366/(MAX_WIDTH+1));
            column.setMinWidth(1366/(MAX_WIDTH+1));
            column.setHalignment(HPos.CENTER);
            this.getColumnConstraints().add(column);
        }

        for (int r = 0; r <= MAX_HEIGHT; r++) {
            RowConstraints row = new RowConstraints();
            row.setMaxHeight(768/(MAX_HEIGHT+1));
            row.setMinHeight(768/(MAX_HEIGHT+1));
            row.setValignment(VPos.BOTTOM);
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

    /**
     * Permet de déplacer le joueur s'il est déplacable sur la case souhaitée
     *
     * @param i l'abscisse de la case sur laquelle le joueur doit se déplacer
     * @param i1 l'ordonnée de la case sur laquelle le joueur doit se déplacer
     */
    public void deplacerJoueur(int i, int i1) {
        if(joueurDeplacable(this.personnage.getPosY() +i,this.personnage.getPosX() + i1)){
            this.getChildren().remove(this.personnage);
            this.personnage.setPosX(this.personnage.getPosX() +i1);
            this.personnage.setPosY(this.personnage.getPosY() +i);
            this.add(this.personnage,this.personnage.getPosX(),this.personnage.getPosY());

        }
    }

    /**
     * Détermine si le joueur est déplacable aux coordonnées envoyées
     *
     * @param i l'abscisse de la case à tester
     * @param i1 l'ordonnée de la case à tester
     *
     * @return true si le joueur peut se déplacer sur cette case, sinon false
     */
    private boolean joueurDeplacable(int i, int i1) {

        boolean result = true;

        if(i<0||i1<0||i>MAX_HEIGHT||i1>MAX_WIDTH) {
            result = false;
        }

        if(getNodeByRowColumnIndex(i, i1) != null){
            if(((ObjetInteractif)getNodeByRowColumnIndex(i,i1)).getEstMarchable()) {
                result = true;
            } else{
                result = false;
            }
        }

        return result;

    }

    /**
     * Permet de retourner l'élément présent sur la case du tableau)
     *
     * @param row l'abscisse de la case
     * @param column l'ordonnée de la case
     *
     * @return l'élément présent sur cette case
     */
    public Node getNodeByRowColumnIndex (final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = this.getChildren();

        for (Node node : childrens) {
            if(this.getRowIndex(node) != null&& this.getColumnIndex(node) != null && this.getRowIndex(node) == row && this.getColumnIndex(node) == column){
                result = node;
                break;
            }
        }
        return result;
    }

    /**
     * @return Renvoie la largeur en pixels d'une case du tableau
     */
    public double getCellWidth() {
        return 1366/(MAX_WIDTH+1);
    }

    /**
     * @return Renvoie la hauteur en pixels d'une case du tableau
     */
    public double getCellHeight() {
        return 768/(MAX_HEIGHT+1);
    }

    public void setDeplacementPrecedent(KeyEvent k){
        this.deplacementPrecedent=k;
    }

    /**
     * Gère l'interaction du joueur sur la carte
     */
    public void interagir() {

        int Xobjet = 0;
        int Yobjet = 0;

        switch (this.deplacementPrecedent.getCode()) {
            case RIGHT:
                Xobjet=this.personnage.getPosX()+1;
                Yobjet=this.personnage.getPosY();
                break;
            case LEFT:
                Xobjet=this.personnage.getPosX()-1;
                Yobjet=this.personnage.getPosY();
                break;
            case UP:
                Xobjet=this.personnage.getPosX();
                Yobjet=this.personnage.getPosY()-1;
                break;
            case DOWN:
                Xobjet=this.personnage.getPosX();
                Yobjet=this.personnage.getPosY()+1;
                break;
            default:
                break;
        }

        if(this.getNodeByRowColumnIndex(Yobjet,Xobjet) != null) {
           ObjetInteractif objet= (ObjetInteractif) getNodeByRowColumnIndex(Yobjet,Xobjet);
           objet.interraction();
        }

    }

    /**
     * Permet de quitter le jeu (affiche un prompt à l'utilisateur)
     */
    public void quitterJeu() {
        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Voulez-vous quitter le jeu");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Voulez-vous quitter le jeu ?");
        Optional<ButtonType> answer = dialogC.showAndWait();

        if (answer.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

}