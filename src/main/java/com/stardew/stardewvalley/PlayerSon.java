package com.stardew.stardewvalley;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class PlayerSon {
    public static void playSon(String str){
        File f = new File(str);
        Media a = new Media(f.toURI().toString());
        MediaPlayer m = new MediaPlayer(a);
        m.play();
    }
}
