package com.stardew.stardewvalley;

import javafx.scene.image.Image;

/**
 * Classe Pierre héritant d'ObjetInteractif
 *
 * @since le 14/03/2023
 * @version le 19/03/2023
 */
public class Pierre extends ObjetInteractif {

    /**
     * Constructeur de Pierre
     *
     * @param pfPosX la position du carré pierre sur les abscisses
     * @param pfPosY la position du carré pierre sur les ordonnées
     */
    public Pierre(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, false);
        Image image = new Image("file:Images/pierre.png");
        setImage(image);
    }

    /**
     * Gère l'interaction du joueur avec la Pierre
     */
    @Override
    public void interraction() {
        super.interraction();
        setImage(null);
        setMarchable(true);
    }
}
