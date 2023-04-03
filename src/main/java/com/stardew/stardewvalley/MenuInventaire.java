package com.stardew.stardewvalley;

import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuInventaire extends GridPane {
    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 10;
    KeyEvent deplacementPrecedent;
    private Image fondCarte = new Image("file:Images/FondInventaire.png");
    public MenuInventaire() {
       // this.setOnKeyPressed(new Clavier(this));
                this.setBackground(new Background(new BackgroundImage(fondCarte,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    /**
     * Permet d'initialiser la Carte
     */
    void initialiserCarte() {

        this.getColumnConstraints().clear();
        this.getRowConstraints().clear();

        for (int c = 0; c <= MAX_WIDTH; c++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMaxWidth((double) 1366/(MAX_WIDTH+1));
            column.setMinWidth((double) 1366/(MAX_WIDTH+1));
            column.setHalignment(HPos.CENTER);
            this.getColumnConstraints().add(column);
        }

        for (int r = 0; r <= MAX_HEIGHT; r++) {
            RowConstraints row = new RowConstraints();
            row.setMaxHeight((double) 768/(MAX_HEIGHT+1));
            row.setMinHeight((double) 768/(MAX_HEIGHT+1));
            row.setValignment(VPos.BOTTOM);
            this.getRowConstraints().add(row);
        }

    }
    public void affichageInventaire(){
        try {
            Stage stage = new Stage();
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("MenuInventaire.fxml"));
            Scene scene = new Scene(root,1366,768);
            stage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            scene.onKeyPressedProperty().bind(root.onKeyPressedProperty());
            stage.getIcons().add(new Image("file:Images/Logo.png"));
            stage.setScene(scene);
            stage.setTitle("AccessibleValley");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
