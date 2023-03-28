package com.stardew.stardewvalley;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Optional;

/**
 * Classe Champ héritant d'ObjetInteractif
 *
 * @since le 13/03/2023
 * @version le 22/03/2023
 */
public class Champ extends ObjetInteractif {

    private boolean estCultive; // Si le champ est cultivé ou non
    private boolean estPlante; // Si le champ est vide ou non
    private Cultures cultive;

    /**
     * Constructeur de Champ
     *
     * @param pfPosX la position du carré champ sur les abscisses
     * @param pfPosY la position du carré champ sur les ordonnées
     */
    public Champ(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, true);
        this.estCultive = false;
        this.estPlante = false;
        this.cultive = Cultures.Vide;
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
            if(this.estPlante) {
                validationRecolte(false);
            } else {
                choixCulture();
            }
        }
    }

    /**
     * Permet de cultiver le champ
     */
    @Override
    public void interraction() throws IOException {
        super.interraction();
        setEstCultive(true);
    }



    /**
     * Permet de cultiver ou non un champ
     * @param b true pour le cultiver, sinon false
     */
    public void validationCulture(boolean b) {

        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Voulez vous cultivez ce champ");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Voulez vous cultivez ce champ");
        Optional<ButtonType> answer = dialogC.showAndWait();

        if (answer.isPresent() && answer.get() == ButtonType.OK) {
            this.estCultive = b;
            this.setImage(new Image("file:Images/champ_cultive.png"));
        }

    }

    /**
     * Permet de cultiver ou non un champ
     * @param b true pour le cultiver, sinon false
     */
    public void validationRecolte(boolean b) {

        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle("Voulez vous récolter ce champ ?");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Voulez vous récolter ce champ ?");
        Optional<ButtonType> answer = dialogC.showAndWait();

        if (answer.isPresent() && answer.get() == ButtonType.OK) {
            this.estPlante = b;
            Inventaire.ajouter(this.cultive);
            this.setImage(new Image("file:Images/champ_cultive.png"));
            this.cultive = Cultures.Vide;
        }

    }

    /**
     * Permet de choisir la culture du champ
     */
    public void choixCulture() {
        Cultures[] choices = {Cultures.Houblon, Cultures.Blé, Cultures.PommeDeTerre,
                Cultures.Tomate, Cultures.Maïs};
        ChoiceDialog<Cultures> cDial = new ChoiceDialog<>(choices[0], choices);
        cDial.setTitle("Choix de la culture");
        cDial.setHeaderText("Selectionner la culture voulu");
        cDial.setContentText("Culture:");
        Optional<Cultures> selection = cDial.showAndWait();
        selection.ifPresent(str -> typeCulture(str));

    }

    /**
     * Modifie l'image du champ en fonction du type de culture
     * @param s le type de champ
     */
    public void typeCulture(Cultures c) {
        switch (c) {
            case Houblon:
                this.setImage(new Image("file:Images/Hops_Stage_8.png"));
                break;
            case Blé:
                this.setImage(new Image("file:Images/Wheat_Stage_5.png"));
                break;
            case PommeDeTerre:
                this.setImage(new Image("file:Images/Potato_Stage_6.png"));
                break;
            case Tomate:
                this.setImage(new Image("file:Images/Tomato_Stage_6.png"));
                break;
            case Maïs:
                this.setImage(new Image("file:Images/Corn_Stage_6.png"));
                break;
            default:
                break;
        }
        this.cultive = c;
        this.estPlante = true;

    }

}
