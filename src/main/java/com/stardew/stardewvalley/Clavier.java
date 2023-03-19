package com.stardew.stardewvalley;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Classe Clavier permettant de capturer la touche enfoncée par le joueur, et de déclencher les actions correspondantes
 * (déplacement du joueur, interaction, quitter le jeu)
 *
 * @version le 19/03/2023
 */
public class Clavier implements EventHandler<KeyEvent> {

    private Carte carte;

    /**
     * Constructeur de Clavier
     * @param carte la carte chargée dans le jeu
     */
    public Clavier(Carte carte) {
        super();
        this.carte = carte;
    }

    /**
     * Capture les différents enfoncement des touches, et déclenche les fonctions correspondantes
     * @param event
     */
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
