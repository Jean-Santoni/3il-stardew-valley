package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private ImageView Play;

    @FXML
    private ImageView Exit;
    @FXML
    private ImageView Fond_Menu;
    @FXML
    private ImageView ImageMenu;

    @FXML
    private AnchorPane Background_Menu;

    @FXML
    public void initialize(){
        Background_Menu.setBackground(new Background(new BackgroundImage(new Image("file:Images/Fond_menu.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        Play.setImage(new Image("file:Images/Play.jpg"));
        Play.setX(300);
        Play.setY(500);
        Play.setOnMouseClicked(event -> {
            try {
                CarteAffichage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Exit.setImage(new Image("file:Images/Exit.jpg"));
        Exit.setX(1000);
        Exit.setY(490);
        Exit.setOnMouseClicked(even ->  ExitJeux());
    }
    @FXML
    BorderPane borderPanel;
    @FXML
    public void CarteAffichage ()throws IOException {
        Stage stage = new Stage();
        //AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
        BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AccessibleValley.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccessibleValley.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(),400,400);
        Scene scene = new Scene(root,1366,768);
        stage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        //scene.setOnKeyPressed(new Clavier(new Carte()));
        scene.onKeyPressedProperty().bind(root.onKeyPressedProperty());
        //stage. setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ExitJeux (){
        System.exit(0);
    }
}
