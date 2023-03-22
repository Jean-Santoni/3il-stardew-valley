package com.stardew.stardewvalley;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * Classe Menu s'affichant au lancement du jeu (boutons "Jouer" et "Quitter")
 *
 * @version le 19/03/2023
 */
public class Menu extends AnchorPane{

    public Menu() {
        super();
        this.setBackground(new Background(new BackgroundImage(new Image("file:Images/Fond_menu.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,
                        true, true,true, true))));
    }

    public Menu(Node... arg0) {
        super(arg0);
    }

}
