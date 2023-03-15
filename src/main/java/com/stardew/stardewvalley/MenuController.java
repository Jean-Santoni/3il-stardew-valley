package com.stardew.stardewvalley;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class MenuController {
    @FXML
    private ImageView Play;

    @FXML
    private ImageView Exit;

    @FXML
    private ImageView Fond_Menu;
    @FXML
    private ImageView ImageMenu;

    @FXML
    private AnchorPane Background_Menu;

    @FXML
    public void initialize(){
        Background_Menu.setBackground(new Background(new BackgroundImage(new Image("file:Images/Fond_menu.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        Play.setImage(new Image("file:Images/Play.jpg"));
        Play.setX(300);
        Play.setY(500);
        Exit.setImage(new Image("file:Images/Exit.jpg"));
        Exit.setX(1000);
        Exit.setY(490);
    }

}
