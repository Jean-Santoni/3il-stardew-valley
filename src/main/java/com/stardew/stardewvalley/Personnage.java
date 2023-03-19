package com.stardew.stardewvalley;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe Personnage héritant d'une Image
 * Retourne et modifie la position du personnage
 *
 * @version le 19/03/2023
 */
public class Personnage extends ImageView {

    private int posX;
    private int posY;

    /**
     * Constructeur Personnage
     */
    public Personnage() {
        this.posX = 0;
        this.posY = 0;
        this.setImage(new Image("file:Images/Personnage.png"));
    }

    /**
     * @return l'abscisse du personnage
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Modifie l'abscisse du personnage
     * @param posX l'abscisse du personnage
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return l'ordonnée du personnage
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Modifie l'ordonnée du personnage
     * @param posY l'ordonnée du personnage
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

}
