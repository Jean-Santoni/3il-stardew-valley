package com.stardew.stardewvalley;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Clavier implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                //Personnage.deplacerX(1);
                break;
            case LEFT:
                //Personnage.deplacerX(-1);
                break;
            case UP:
                //Personnage.deplacerY(1);
                break;
            case DOWN:
                //Personnage.deplacerY(-1);
                break;
            default:
                break;
        }
    }
}
