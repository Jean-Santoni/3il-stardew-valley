package com.stardew.stardewvalley;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Menu extends AnchorPane{

    public Menu() {
        super();
        this.setBackground(new Background(new BackgroundImage(new Image("file:Images/Fond_menu.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
    }
    public Menu(Node... arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

}
