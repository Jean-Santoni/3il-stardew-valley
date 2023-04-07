package com.stardew.stardewvalley;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Classe Clavier permettant de capturer la touche enfoncée par le joueur, et de déclencher les actions correspondantes
 * (déplacement du joueur, interaction, quitter le jeu)
 *
 * @version le 22/03/2023
 */
public class Clavier implements EventHandler<KeyEvent> {

    private Carte carte;
    private SousTitres sousTitres;
    private MenuInventaire menuInventaire;

    /**
     * Constructeur de Clavier
     * @param carte la carte chargée dans le jeu
     */
    public Clavier(Carte carte, SousTitres sousTitres) {
        super();
        this.carte = carte;
        this.sousTitres = sousTitres;
    }
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
                /*
                if(MenuInventaire.estAffiche()){
                    this.menuInventaire.fermerInventaire();
                }else{
                    this.menuInventaire.affichageInventaire();
                }*/
                this.menuInventaire.affichageInventaire();
                break;
            case A:
                PlayerSon.activerDesactiverSon();
                break;
            case S:
                if (this.sousTitres != null) {
                    this.sousTitres.activerDesactiverSousTitres();
                    this.carte.initialiserCarte(this.sousTitres.estActive());
                }
                break;
            case P:
                Personnage p = this.carte.getPersonnage();
                //play son Vous etes à la position

                    PlayerSon.nombreVersSon(p.getPosX());
                    PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(event2 -> {

                            PlayerSon.nombreVersSon(p.getPosY());

                    });
                    pause.play();


                //play son En X et

                //play son En Y
                break;
            default:
                break;
        }
    }
}
