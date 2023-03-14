package com.stardew.stardewvalley;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Personnage extends ImageView {
    private int posX;
    private int posY;

    public Personnage() {
        this.posX = 0;
        this.posY = 0;
        this.setImage(new Image("file:Images/Personnage.png"));
    }

}
