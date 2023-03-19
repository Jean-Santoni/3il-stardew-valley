package com.stardew.stardewvalley;

import javafx.scene.image.ImageView;

/**
 * Classe abstraite ObjetInteractif
 *
 * @since le 13/03/2023
 * @version le 14/03/2023
 *
 * @author Nicolas Ferrayé, Jean Santoni - 3iL
 */
public abstract class ObjetInteractif extends ImageView {

    private int posX;
    private int posY;
    private boolean marchable;

    private ImageView image; // Image associée à l'ObjetInteractif

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
    public boolean getEstMarchable() {
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
    public void interraction(){
    }


}
