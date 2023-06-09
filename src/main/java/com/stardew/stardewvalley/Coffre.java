package com.stardew.stardewvalley;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Optional;

/**
 * Classe Coffre héritant d'ObjetInteractif
 */
public class Coffre extends ObjetInteractif {

    /**
     * Constructeur Coffre
     *
     * @param pfPosX la position du coffre sur les abscisses
     * @param pfPosY la position du coffre sur les ordonnées
     */
    public Coffre(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, false);
        Image image = new Image("file:Images/Chest.png");
        setImage(image);
    }

    /**
     * Gère l'interaction du joueur avec la le coffre
     */
    @Override
    public void interraction() throws IOException {
        super.interraction();
        SousTitres.setTexte("*Ouverture de coffre*");
        validationVendre(true);

    }

    /**
     * Permet de valider ou non la vente
     * @param b true pour valider, sinon false
     */
    public void validationVendre(boolean b) {
        Cultures[] choices = {Cultures.Houblon, Cultures.Blé, Cultures.PommeDeTerre,
                Cultures.Tomate, Cultures.Maïs};
        ChoiceDialog<Cultures> cDial = new ChoiceDialog<>(choices[0], choices);
        cDial.setTitle("Marché");
        cDial.setHeaderText("Que voulez-vous vendre ?");
        PlayerSon.playSon("Son/VendreRessource.wav");
        Optional<Cultures> selection = cDial.showAndWait();
        selection.ifPresent(str -> vendre(str));
    }

    /**
     * Permet de vendre au coffre
     * @param c la culture à vendre
     */
    private void vendre(Cultures c){
        int prixVente = Inventaire.getNbCulture(c);
        switch (c){
            case Houblon:
                prixVente *= 10;
                break;
            case Blé:
                prixVente *= 100;
                break;
            case PommeDeTerre:
                prixVente *= 1000;
                break;
            case Tomate:
                prixVente *= 10000;
                break;
            case Maïs:
                prixVente *= 100000;
                break;
            default:
                break;
        }

        for(int i=0 ; i<Inventaire.getNbCulture(c) ; i++){
            Inventaire.retirer(c);
            Inventaire.ajouterArgent(prixVente);
        }

        PlayerSon.playSon("Son/venteEffectuee.wav");
        SousTitres.setTexte("*Fermeture de coffre*");
    }
}
