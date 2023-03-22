package com.stardew.stardewvalley;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe Maison héritant d'ObjetInteractif
 *
 * @since le 22/03/2023
 * @version le 22/03/2023
 */
public class Maison extends ObjetInteractif {

    private boolean porte;
    private Stage stage = new Stage();
     private BorderPane root ;
    private boolean exterieur;

    public Maison(int pfPosX, int pfPosY,boolean porte,boolean exterieur) {
        super(pfPosX, pfPosY, false);
        this.porte=porte;
        this.exterieur=exterieur;
    }

    @Override
    public void interraction() throws IOException {
        if(this.porte){
           if(this.exterieur){
               entrerMaison();
           }else {
               sortirMaison();
               System.out.println("coucou");
           }
        }
    }
    public void entrerMaison() throws IOException {

       this.root= (BorderPane) FXMLLoader.load(getClass().getResource("InterieurMaison.fxml"));
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
    public void sortirMaison() throws IOException {
        this.stage.close();
    }

}
