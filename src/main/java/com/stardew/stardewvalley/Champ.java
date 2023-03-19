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
            this.estCultive = pfEstCultive;
            this.setImage(new Image("file:Images/champ_cultive.png"));
        } else {
            choixCulture();
            //this.setImage(new Image("file:Images/champ_non_cultive.png"));
        }
    }
    @Override
    public void interraction() {
        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Voulez vous cultivez ce champs");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Voulez vous cultivez ce champs");
        Optional<ButtonType> answer = dialogC.showAndWait();
        if (answer.get() == ButtonType.OK) {
            System.out.println("User chose OK");
            super.interraction();
            setEstCultive(true);
        }
        else {
            System.out.println("User chose Cancel or closed the dialog-box");
        }

    }
    public void choixCulture() {
        String[] choices = {"Riz", "Blé", "Patate", "Tomate"};
        ChoiceDialog<String> cDial = new ChoiceDialog<>(choices[2], choices);
        cDial.setTitle("A Choice Dialog");
        cDial.setHeaderText("Selectionner la culture voulu");
        cDial.setContentText("Culture:");
        Optional<String> selection = cDial.showAndWait();
        selection.ifPresent(str -> System.out.println("Selection:" + str));

    }



}
