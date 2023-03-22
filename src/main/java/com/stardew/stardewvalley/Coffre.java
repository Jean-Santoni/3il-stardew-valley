package com.stardew.stardewvalley;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
        String[] choices = {"Houblon", "Blé", "Pattate", "Tomate","Maïs"};
        ChoiceDialog<String> cDial = new ChoiceDialog<>(choices[2], choices);
        cDial.setTitle("Marché");
        cDial.setHeaderText("Que voulez-vous vendre ?");
        Optional<String> selection = cDial.showAndWait();
        selection.ifPresent(str -> System.out.println("Selection:" + str));

    }
}
