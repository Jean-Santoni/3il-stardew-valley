package com.stardew.stardewvalley;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Optional;

public class Coffre extends ObjetInteractif {
    public Coffre(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, false);
        Image image = new Image("file:Images/Chest.png");
        setImage(image);
    }
        @Override
        public void interraction() throws IOException {
            super.interraction();
            validationVendre(true);

        }
        public void validationVendre(boolean b) {
        Cultures[] choices = {Cultures.Houblon, Cultures.Blé, Cultures.PommeDeTerre,
                Cultures.Tomate, Cultures.Maïs};
        ChoiceDialog<Cultures> cDial = new ChoiceDialog<>(choices[0], choices);
        cDial.setTitle("Marché");
        cDial.setHeaderText("Que voulez-vous vendre ?");
        Optional<Cultures> selection = cDial.showAndWait();
        selection.ifPresent(str -> vendre(str));
    }
    private void vendre(Cultures c){
        int prix = 0;
        switch (c){
            case Houblon:
                prix = 10;
                break;
            case Blé:
                prix = 100;
                break;
            case PommeDeTerre:
                prix = 1000;
                break;
            case Tomate:
                prix = 10000;
                break;
            case Maïs:
                prix = 100000;
                break;
            default:
                break;
        }
        for(int i=0; i<Inventaire.getNbCulture(c);i++){
            Inventaire.retirer(c);
            Inventaire.ajouterArgent(prix);
        }
    }
}
