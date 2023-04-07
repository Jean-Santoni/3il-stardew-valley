package com.stardew.stardewvalley;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Timer;

import static java.lang.Thread.sleep;

public class PlayerSon {
    private static boolean estActive = true;
    private static MediaPlayer m;


    public static void activerDesactiverSon(){
        PlayerSon.estActive = !PlayerSon.estActive;
    }

    /**

     Joue le fichier son si le son est actif.
     @param str Chemin d'accès au fichier son à lire.
     */
    public static void playSon(String str){
        if (estActive){
            File f = new File(str);
            Media a = new Media(f.toURI().toString());
             m = new MediaPlayer(a);
            m.play();
        }
    }
    /**

     Convertit le nombre donné en son et le joue.

     @param i Le nombre à convertir en son.
     */
    public static void nombreVersSon(int i)  {

            playSon("Son/Chiffre"+i+".wav");

        }

}
