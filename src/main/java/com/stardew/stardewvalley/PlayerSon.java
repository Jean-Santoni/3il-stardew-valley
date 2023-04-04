package com.stardew.stardewvalley;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import static java.lang.Thread.sleep;

public class PlayerSon {
    private static boolean estActive = true;

    public static void activerDesactiverSon(){
        PlayerSon.estActive = !PlayerSon.estActive;
    }
    public static void playSon(String str){
        if (estActive){
            File f = new File(str);
            Media a = new Media(f.toURI().toString());
            MediaPlayer m = new MediaPlayer(a);
            m.play();
        }
    }

    public static void nombreVersSon(int i){
        String nombre = String.valueOf(i);

        char[] chiffre = nombre.toCharArray();

        for(int j = 0; j < chiffre.length; j++) {
            playSon("Son/Chiffre"+chiffre[j]+".wav");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
