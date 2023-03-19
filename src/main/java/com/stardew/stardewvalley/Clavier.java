package com.stardew.stardewvalley;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Clavier implements EventHandler<KeyEvent> {
    private Carte carte;
    public Clavier(Carte carte) {
        super();
        this.carte = carte;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                //Personnage.deplacerX(1);
                this.carte.deplacerJoueur(0,1);
                this.carte.setDeplacementPrecedent(event);
                break;
            case LEFT:
                //Personnage.deplacerX(-1);
                this.carte.deplacerJoueur(0,-1);
                this.carte.setDeplacementPrecedent(event);
                break;
            case UP:
                //Personnage.deplacerY(1);
                this.carte.deplacerJoueur(-1,0);
                this.carte.setDeplacementPrecedent(event);
                break;
            case DOWN:
                //Personnage.deplacerY(-1);
                this.carte.deplacerJoueur(1,0);
                this.carte.setDeplacementPrecedent(event);
                break;
            case SHIFT:
                //Personnage.deplacerY(-1);
                this.carte.interagir();
                break;
            case ESCAPE:
                //Personnage.deplacerY(-1);
                this.carte.quitterJeu();
                break;
            default:
                break;
        }
    }
}
