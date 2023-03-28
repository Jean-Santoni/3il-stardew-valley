package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe MenuController permettant de gérer le menu (Controleur MVC de la classe Menu)
 *
 * @version le 19/03/2023
 */
public class MenuController {

    private final int MAX_WIDTH = 4;
    private final int MAX_HEIGHT = 4;

    @FXML
    private ImageView Play;

    @FXML
    private GridPane Grille_Menu;

    @FXML
    private ImageView Exit;

    @FXML
    private ImageView Fond_Menu;

    @FXML
    private ImageView ImageMenu;

    @FXML
    private AnchorPane Background_Menu;

    /**
     * Gère les différentes actions du menu, et ajoute l'image de fond de la fenêtre
     */
    @FXML
    public void initialize() {
        Background_Menu.setBackground(new Background(new BackgroundImage(new Image("file:Images/Fond_menu.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));

        Play.setImage(new Image("file:Images/Play.png"));

        Play.setOnMouseClicked(event -> {
           try {
                CarteAffichage();

           } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Exit.setImage(new Image("file:Images/Exit.png"));

        Exit.setOnMouseClicked(even ->  ExitJeux());
        initialiserMenu(Grille_Menu);
        Play.setFitWidth(1366/(MAX_WIDTH+1));
        Play.setFitHeight(768/(MAX_HEIGHT+1));
        Exit.setOnMouseEntered(event -> PlayerSon.playSon("Son/Exit.wav"));
        Play.setOnMouseEntered(event -> PlayerSon.playSon("Son/Play.wav"));

        Exit.setFitWidth(1366/(MAX_WIDTH+1));
        Exit.setFitHeight(768/(MAX_HEIGHT+1));
        PlayerSon.playSon("Son/Menu.wav");
    }
    @FXML
    BorderPane borderPanel;

    /**
     * Affiche la carte
     * @throws IOException
     */
    @FXML
    public void CarteAffichage () throws IOException {
        Stage stage = new Stage();
        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AccessibleValley.fxml"));
        Scene scene = new Scene(root,1366,768);
        stage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        scene.onKeyPressedProperty().bind(root.onKeyPressedProperty());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("file:Images/Logo.png"));
        stage.setTitle("AccessibleValley");
        stage.show();
    }

    /**
     * Permet de quitter la partie
     */
    @FXML
    public void ExitJeux (){
        System.exit(0);
    }

    /**
     * Initialise le menu
     * @param grid
     */
    private void initialiserMenu(GridPane grid) {

        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();

        for (int c = 0; c <= MAX_WIDTH; c++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setMaxWidth(1366/(MAX_WIDTH+1));
            column.setMinWidth(1366/(MAX_WIDTH+1));
            grid.getColumnConstraints().add(column);
        }

        for (int r = 0; r <= MAX_HEIGHT; r++) {
            RowConstraints row = new RowConstraints();
            row.setMaxHeight(768/(MAX_HEIGHT+1));
            row.setMinHeight(768/(MAX_HEIGHT+1));
            grid.getRowConstraints().add(row);
        }

    }
}
