package com.stardew.stardewvalley;

import javafx.scene.image.Image;

/**
 * Classe abstraite ObjetInteractif
 *
 * @since le 13/03/2023
 * @version le 13/03/2023
 *
 * @author Nicolas Ferrayé - 3iL
 */
public abstract class ObjetInteractif {

    private int posX;
    private int posY;
    private Image image;
    private boolean marchable;

    public ObjetInteractif(int pfPosX, int pfPosY, boolean pfMarchable) {
        this.posX = pfPosX;
        this.posY = pfPosY;
        this.marchable = pfMarchable;
    }

    /**
     * @return l'abscisse de l'objet
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * @return l'ordonnée de l'objet
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * @return true si l'objet est marchable, sinon false
     */
    public boolean estMarchable() {
        return this.marchable;
    }

    /**
     * Modifie l'abscisse de l'objet
     *
     * @param pfPosX la nouvelle abscisse
     */
    public void setPosX(int pfPosX) {
        this.posX = pfPosX;
    }
    public void setImage(Image image ){
        this.image = image;
    }

    /**
     * Modifie l'ordonnée de l'objet
     *
     * @param pfPosY la nouvelle ordonnée
     */
    public void setPosY(int pfPosY) {
        this.posY = pfPosY;
    }

    /**
     * @param pfMarchable
     */
    public void setMarchable(boolean pfMarchable) {
        this.marchable = pfMarchable;
    }

}
