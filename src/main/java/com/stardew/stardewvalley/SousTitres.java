package com.stardew.stardewvalley;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

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
        texte.setAlignment(Pos.CENTER);
        texte.setTextAlignment(TextAlignment.CENTER);
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
