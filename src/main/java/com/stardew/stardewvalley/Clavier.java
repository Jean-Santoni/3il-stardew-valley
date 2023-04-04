package com.stardew.stardewvalley;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

/**
 * Classe Clavier permettant de capturer la touche enfoncée par le joueur, et de déclencher les actions correspondantes
 * (déplacement du joueur, interaction, quitter le jeu)
 *
 * @version le 22/03/2023
 */
public class Clavier implements EventHandler<KeyEvent> {

    private Carte carte;
    private MenuInventaire menuInventaire;

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
                this.carte.deplacerJoueur(0,1);
                this.carte.setDeplacementPrecedent(event);
                break;
            case LEFT:
                this.carte.deplacerJoueur(0,-1);
                this.carte.setDeplacementPrecedent(event);
                break;
            case UP:
                this.carte.deplacerJoueur(-1,0);
                this.carte.setDeplacementPrecedent(event);
                break;
            case DOWN:
                this.carte.deplacerJoueur(1,0);
                this.carte.setDeplacementPrecedent(event);
                break;
            case SHIFT:
                try {
                    this.carte.interagir();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case ESCAPE:
                this.carte.quitterJeu();
                break;
            case SPACE:
                if(this.menuInventaire == null){
                    this.menuInventaire=new MenuInventaire();
                }
                this.menuInventaire.affichageInventaire();
                break;
            case A:
                PlayerSon.activerDesactiverSon();
                break;
            case P:

                break;
            default:
                break;
        }
    }
}
