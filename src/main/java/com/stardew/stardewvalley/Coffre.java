package com.stardew.stardewvalley;

import javafx.scene.image.Image;

import java.io.IOException;

public class Coffre extends ObjetInteractif {
    public Coffre(int pfPosX, int pfPosY) {
        super(pfPosX, pfPosY, false);
        Image image = new Image("file:Images/Chest.png");
        setImage(image);
    }
    @Override
    public void interraction() throws IOException {
        super.interraction();
        setImage(null);

    }

}
