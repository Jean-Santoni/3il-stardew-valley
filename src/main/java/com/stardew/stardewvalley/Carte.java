package com.stardew.stardewvalley;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Carte extends GridPane {
    private final int MAX_WIDTH = 20;
    private final int MAX_HEIGHT = 50;

    public Carte() {
        super();
        initialiserCarte();
        this.setBackground(new Background(new BackgroundImage(new Image("file:Images/Map.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
    }

    private void initialiserCarte() {
        this.getColumnConstraints().clear();
        this.getRowConstraints().clear();
        for (int c = 0; c <= MAX_WIDTH; c++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 2);
            this.getColumnConstraints().add(column);
        }
        for (int r = 0; r <= MAX_HEIGHT; r++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 3);
            this.getRowConstraints().add(row);
        }
        this.setGridLinesVisible(true);
       /* int collIndex = 0;
        int rowIndex = 0;
        int listeIndex = 0;
        for (collIndex = 0; collIndex <= 2; collIndex++) {
            for (rowIndex = 0; rowIndex <= 3; rowIndex++) {
                ImageView n = new ImageView();
                if(ListeCarte.get(listeIndex).isClique()==false) {
                    n.setImage(ListeCarte.get(listeIndex).getDos());
                }else if(ListeCarte.get(listeIndex).isValide() && ListeCarte.get(listeIndex).isClique() ){
                    n.setImage(ListeCarte.get(listeIndex).getValide());
                }else {
                    n.setImage(ListeCarte.get(listeIndex).getFace());
                }
                n.setFitWidth(100.0);
                n.setFitHeight(100.0);
                Carte carteTampon = ListeCarte.get(listeIndex);
                n.setOnMouseClicked(event ->CliqueCase(carteTampon) );
                this.add(n, collIndex, rowIndex);
                listeIndex++;
            }
        }
        listeIndex=0;*/
    }


}