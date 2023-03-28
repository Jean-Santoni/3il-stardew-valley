package com.stardew.stardewvalley;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

/**
 * Interface de l'intérieur de la Maison
 */
public class MaisonInterieur extends Carte {

    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 10;
    private KeyEvent deplacementPrecedent;
    private Image fondCarte = new Image("file:Images/Maison_interieur.png");

    private Personnage personnage;

    /**
     * Constructeur de Carte
     */
    public MaisonInterieur() {

        super();

        this.setOnKeyPressed(new Clavier(this));
        initialiserCarte();

        super.personnage.setPreserveRatio(true);
        super.personnage.setFitHeight(100);
        this.getChildren().remove(super.personnage);
        super.personnage.setPosX(8);
        super.personnage.setPosY(8);
        this.add(super.personnage,super.personnage.getPosX(),super.personnage.getPosY());
        this.setBackground(new Background(new BackgroundImage(fondCarte,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    /**
     * Permet d'initialiser la Carte
     */
    public void initialiserCarte() {

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
}
