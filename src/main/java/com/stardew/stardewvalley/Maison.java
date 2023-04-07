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
    private Stage stage;
    private BorderPane root ;
    private boolean exterieur;

    /**
     * Constructeur Maison
     *
     * @param pfPosX la position de la maison sur les abscisses
     * @param pfPosY la position de la maison d'herbe sur les ordonnées
     * @param porte
     * @param exterieur
     */
    public Maison(int pfPosX, int pfPosY, boolean porte, boolean exterieur) {
        super(pfPosX, pfPosY, false);
        this.porte=porte;
        this.exterieur=exterieur;
    }

    /**
     * Gère l'interaction du joueur avec la maison
     *
     * @throws IOException
     */
    @Override
    public void interraction() throws IOException {
        if(this.porte) {
            if(this.exterieur){
                entrerMaison();
            } else {
                sortirMaison();
            }
            PlayerSon.playSon("Son/DOOR.wav");
            SousTitres.setTexte("*Ouverture de porte*");
        }
    }

    /**
     * Permet d'entrer dans la maison depuis la Carte
     * @throws IOException
     */
    public void entrerMaison() throws IOException {
        if(this.stage == null){
            this.stage = new Stage();
            this.root= (BorderPane) FXMLLoader.load(getClass().getResource("InterieurMaison.fxml"));
            Scene scene = new Scene(root,1366,768);
            stage.setResizable(false);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            scene.onKeyPressedProperty().bind(root.onKeyPressedProperty());
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.getIcons().add(new Image("file:Images/Logo.png"));
            stage.setTitle("AccessibleValley");
        }
        stage.show();
    }

    /**
     * Permet de sortir de la maison et revenir sur la Carte
     * @throws IOException
     */
    public void sortirMaison() {
        ((Stage)this.getScene().getWindow()).close();
    }

}
