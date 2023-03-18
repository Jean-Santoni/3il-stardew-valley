package com.stardew.stardewvalley;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
           // BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AccessibleValley.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccessibleValley.fxml"));
       // Scene scene = new Scene(fxmlLoader.load(),400,400);
        Scene scene = new Scene(root,1366,768);
        stage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        //scene.setOnKeyPressed(new Clavier(new Carte()));
        scene.onKeyPressedProperty().bind(root.onKeyPressedProperty());
        //stage. setFullScreen(true);
        stage.setScene(scene);
        stage.setTitle("AccessibleValley");
        stage.show();

        } catch(Exception e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        launch();}
    
}