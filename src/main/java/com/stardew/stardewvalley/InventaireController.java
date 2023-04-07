package com.stardew.stardewvalley;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;

public class InventaireController {
    private Clavier clavier;
    private MenuInventaire menuI;
    @FXML
    private BorderPane inventaire;

    /**
     * Initialise la Maison, la hauteur, la largeur, la position
     */
    @FXML
    private void initialize()  {
        if(clavier == null){

            this.menuI = new MenuInventaire();
            this.inventaire.setMaxHeight(768);
            this.inventaire.setMaxWidth(1366);
            this.inventaire.setCenter(this.menuI);
            this.menuI.initialiserCarte();
            intitInventaire();
            initValues();
            audioInventaire(Cultures.Houblon);
            PauseTransition pause = new PauseTransition(Duration.seconds(6));
            pause.setOnFinished(event1 -> {
                audioInventaire(Cultures.Maïs);
            });

            PauseTransition pause2 = new PauseTransition(Duration.seconds(12));
            pause2.setOnFinished(event3 -> {
                audioInventaire(Cultures.Blé);
            });
            PauseTransition pause3 = new PauseTransition(Duration.seconds(18));
            pause3.setOnFinished(event4 -> {
                audioInventaire(Cultures.PommeDeTerre);
            });

            PauseTransition pause4 = new PauseTransition(Duration.seconds(24));
            pause4.setOnFinished(event5 -> {
                audioInventaire(Cultures.Tomate);
            });
            pause.play();
            pause2.play();
            pause3.play();
            pause4.play();



           // this.clavier = new Clavier(this.menuI);
            this.inventaire.setOnKeyPressed(this.clavier);
        }

    }

    private void intitInventaire(){

        Image houblon = new Image("file:Images/Hops.png");
        Image blé = new Image("file:Images/Wheat.png");
        Image tomate = new Image("file:Images/Tomato.png");
        Image pommeDeTerre = new Image("file:Images/Potato.png");
        Image mais = new Image("file:Images/Corn.png");
        Image coin = new Image("file:Images/Gold.png");
        ImageView i1 =new ImageView(houblon);
        ImageView i2 =new ImageView(blé);
        ImageView i3 =new ImageView(tomate);
        ImageView i4 =new ImageView(pommeDeTerre);
        ImageView i5 =new ImageView(mais);
        ImageView i6 =new ImageView(coin);
        this.menuI.add(i1,8,4);
        this.menuI.add(i2,8,5);
        this.menuI.add(i3,8,6);
        this.menuI.add(i4,11,4);
        this.menuI.add(i5,11,5);
        this.menuI.add(i6,11,6);
    }
    public void initValues(){
        Label nbH = createLabel(Cultures.Houblon);
        Label nbB = createLabel(Cultures.Blé);
        Label nbT = createLabel(Cultures.Tomate);
        Label nbP = createLabel(Cultures.PommeDeTerre);
        Label nbM = createLabel(Cultures.Maïs);

        Label nbC = new Label();
        nbC.setText(Integer.toString(Inventaire.getArgent()));
        nbC.setFont(new Font(32));

        addLabelsToMenu(this.menuI, nbH, nbB, nbT, nbP, nbM, nbC);
    }

    public Label createLabel(Cultures cultures) {
        Label label = new Label();
        label.setText(Integer.toString(Inventaire.getNbCulture(cultures)));
        label.setFont(new Font(32));
        return label;
    }

    public void addLabelsToMenu(MenuInventaire menu, Label... labels) {
        int index = 0;
        int[] columns = {9, 12};
        int[] rows = {4, 5, 6};
        for (Label label : labels) {
            menu.add(label, columns[index % 2], rows[index % 3]);
            index++;
        }
    }
    public void audioInventaire(Cultures cultures) {

           PlayerSon.playSon("Son/NombreCulture.wav");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event2 -> {

            switch (cultures){
                case Houblon :
                    PlayerSon.playSon("Son/Houblon.wav");
                    break;
                case Maïs:
                    PlayerSon.playSon("Son/Mais.wav");
                    break;
                case Blé:
                    PlayerSon.playSon("Son/Ble.wav");
                    break;
                case PommeDeTerre:
                    PlayerSon.playSon("Son/PommeDeTerre.wav");
                    break;
                case Tomate:PlayerSon.playSon("Son/Tomate.wav");
                    break;
            }

        });
        pause.play();
        PauseTransition pause2 = new PauseTransition(Duration.seconds(3));
        pause2.setOnFinished(event2 -> {
            PlayerSon.nombreVersSon(Inventaire.getNbCulture(cultures));


        });
        pause2.play();



    }
}
