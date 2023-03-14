package com.stardew.stardewvalley;

import javafx.scene.image.Image;

/**
 * Classe Herbe héritant d'ObjetInteractif
 *
 * @since le 14/03/2023
 * @version le 14/03/2023
 *
 * @author Nicolas Ferrayé - 3iL
 */
public class Herbe extends ObjetInteractif {

    /**
     * Constructeur d'Herbe
     *
     * @param pfPosX la position du carré d'herbe sur les abscisses
     * @param pfPosY la position du carré d'herbe sur les ordonnées
     */
    public Herbe(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, true);
        Image image = new Image("file:Images/herbe.png");
        setImage(image);
    }
}
