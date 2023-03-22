package com.stardew.stardewvalley;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe permettant de lancer le jeu AccessibleValley
 *
 * @version le 22/03/2023
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
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

    /**
     * Main function
     */
    public static void main(String[] args) {
        launch();
    }
    
}