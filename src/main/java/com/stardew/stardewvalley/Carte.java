package com.stardew.stardewvalley;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Carte extends Pane {

    public Carte() {
        super();
        this.setBackground(new Background(new BackgroundImage(new Image("file:Images/Map.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
    }

    public Carte(Node... arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

}