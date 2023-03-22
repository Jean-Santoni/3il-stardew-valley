package com.stardew.stardewvalley;

import javafx.scene.image.Image;

public class Inventaire {
    private static int nbHoublon;
    private static int nbBle;
    private static int nbPommeDeTerre;
    private static int nbTomate;
    private static int nbMais;
    private static int argent;

    public static void ajouter(String ajout) {
        switch (ajout){
            case "Houblon":
                nbHoublon ++;
                break;
            case "Blé":
                nbBle ++;
                break;
            case "Patate":
                nbPommeDeTerre ++;
                break;
            case "Tomate":
                nbTomate ++;
                break;
            case "Maïs":
                nbMais ++;
                break;
            default:
                break;
        }
        System.out.println(nbHoublon);
        System.out.println(nbBle);
        System.out.println(nbPommeDeTerre);
        System.out.println(nbTomate);
        System.out.println(nbMais);
    }
}
