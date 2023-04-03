package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

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
}
