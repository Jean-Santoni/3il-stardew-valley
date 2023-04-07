package com.stardew.stardewvalley;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SousTitres extends Pane {

    private static boolean estActive = true;
    public void activerDesactiverSousTitres(){
        estActive = !estActive;
        this.getChildren().get(0).setVisible(estActive);
    }
    private static Label texte;
    public SousTitres() {
        super();
        texte = new Label();
        texte.setText("");
        if(estActive){
            this.getChildren().add(texte);
        }
    }
    public static void setTexte(String t){
        texte.setText(t);
    }

    public boolean estActive(){
        return estActive;
    }
}
