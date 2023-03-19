package com.stardew.stardewvalley;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;

import java.util.Optional;

/**
 * Classe Champ héritant d'ObjetInteractif
 *
 * @since le 13/03/2023
 * @version le 14/03/2023
 *
 * @author Nicolas Ferrayé - 3iL
 */
public class Champ extends ObjetInteractif {

    private boolean estCultive; // Si le champ est cultivé ou non

    /**
     * Constructeur de Champ
     *
     * @param pfPosX la position du carré champ sur les abscisses
     * @param pfPosY la position du carré champ sur les ordonnées
     */
    public Champ(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, true);
        this.estCultive = false;
        this.setImage(new Image("file:Images/champ_non_cultive.png"));
    }

    /**
     * @return true si le champ est cultivé, sinon false
     */
    public boolean getEstCultive() {
        return this.estCultive;
    }

    /**
     * @param pfEstCultive si le champ est cultivé ou non
     */
    public void setEstCultive(boolean pfEstCultive) {



        if(!this.estCultive) {
            validationCulture(pfEstCultive);
        } else {
            choixCulture();
            //this.setImage(new Image("file:Images/champ_non_cultive.png"));
        }
    }
    @Override
    public void interraction() {

            super.interraction();
            setEstCultive(true);


    }
    public void validationCulture(boolean b) {
        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Voulez vous cultivez ce champs");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Voulez vous cultivez ce champs");
        Optional<ButtonType> answer = dialogC.showAndWait();
        if (answer.get() == ButtonType.OK) {
            this.estCultive = b;
            this.setImage(new Image("file:Images/champ_cultive.png"));
        }
        else {
            System.out.println("User chose Cancel or closed the dialog-box");
        }

    }
    public void choixCulture() {
        String[] choices = {"Houblon", "Blé", "Patate", "Tomate","Maïs"};
        ChoiceDialog<String> cDial = new ChoiceDialog<>(choices[2], choices);
        cDial.setTitle("Choix de la culture");
        cDial.setHeaderText("Selectionner la culture voulu");
        cDial.setContentText("Culture:");
        Optional<String> selection = cDial.showAndWait();
        selection.ifPresent(str -> typeCulture(str));

    }

    public void typeCulture(String s) {
        switch (s) {
            case "Houblon":
                this.setImage(new Image("file:Images/Hops_Stage_8.png"));
                break;
            case "Blé":
                this.setImage(new Image("file:Images/Wheat_Stage_5.png"));
                break;
            case "Patate":
                //Personnage.deplacerY(1);
                this.setImage(new Image("file:Images/Potato_Stage_6.png"));
                break;
            case "Tomate":
                this.setImage(new Image("file:Images/Tomato_Stage_6.png"));
                break;
            case "Maïs":
                this.setImage(new Image("file:Images/Corn_Stage_6.png"));
                break;
            default:
                break;
        }

    }



}
