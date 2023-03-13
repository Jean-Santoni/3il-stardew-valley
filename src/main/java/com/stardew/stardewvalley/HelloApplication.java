package com.stardew.stardewvalley;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
       // BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AccessibleValley.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccessibleValley.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400,400);
      //  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        scene.setOnKeyPressed(new Clavier());
        stage.setScene(scene);
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        launch();
    }
}