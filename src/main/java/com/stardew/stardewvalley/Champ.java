package com.stardew.stardewvalley;

/**
 * Classe Champ héritant d'ObjetInteractif
 *
 * @since le 13/03/2023
 * @version le 13/03/2023
 *
 * @author Nicolas Ferrayé - 3iL
 */
public class Champ extends ObjetInteractif {

    private boolean estCultive; // Si le champ est cultivé ou non

    public Champ(int pfPosX, int pfPosY, boolean pfEstCultive) {
        super(pfPosX, pfPosY, true);
        this.estCultive = pfEstCultive;
    }

    /**
     * @return true si le champ est cultivé, sinon false
     */
    public boolean getEstCultive() {
        return this.estCultive;
    }

    /**
     * @param pfEstCultive si le champ est cultivé ou non
     */
    public void setEstCultive(boolean pfEstCultive) {
        this.estCultive = pfEstCultive;
    }

}
