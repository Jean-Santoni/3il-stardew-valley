package com.stardew.stardewvalley;

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

    public ObjetInteractif(int pfPosX, int pfPosY) {
        this.posX = pfPosX;
        this.posX = pfPosY;
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

}
