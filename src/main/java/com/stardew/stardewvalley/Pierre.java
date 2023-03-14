package com.stardew.stardewvalley;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

/**
 * Classe com.stardew.stardewvalley.Pierre héritant d'ObjetInteractif
 *
 * @since le 14/03/2023
 * @version le 14/03/2023
 *
 * @author Nicolas Ferrayé - 3iL
 */
public class Pierre extends ObjetInteractif {

    public Pierre(int pfPosX, int pfPosY) throws FileNotFoundException {
        super(pfPosX, pfPosY, false);

        Image image = new Image(new FileInputStream("file:Images/pierre.png"));

        setImage(image);
    }

}
