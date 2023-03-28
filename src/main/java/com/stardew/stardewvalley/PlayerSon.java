package com.stardew.stardewvalley;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Permet de lire un fichier son .waw
 */
public class PlayerSon {
    private static MediaPlayer m;
    public static void playSon(String str){

        File f = new File(str);
        Media a = new Media(f.toURI().toString());
        m = new MediaPlayer(a);
        m.play();
    }
}
