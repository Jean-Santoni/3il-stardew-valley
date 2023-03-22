package com.stardew.stardewvalley;

public class Inventaire {
    private static int nbHoublon;
    private static int nbBle;
    private static int nbPommeDeTerre;
    private static int nbTomate;
    private static int nbMais;
    private static int argent;

    public static void ajouter(Cultivations ajout) {
        switch (ajout){
            case Houblon:
                nbHoublon ++;
                break;
            case Blé:
                nbBle ++;
                break;
            case PommeDeTerre:
                nbPommeDeTerre ++;
                break;
            case Tomate:
                nbTomate ++;
                break;
            case Maïs:
                nbMais ++;
                break;
            default:
                break;
        }
    }
    public static void retirer(Cultivations retirer) {
        switch (retirer){
            case Houblon:
                nbHoublon --;
                break;
            case Blé:
                nbBle --;
                break;
            case PommeDeTerre:
                nbPommeDeTerre --;
                break;
            case Tomate:
                nbTomate --;
                break;
            case Maïs:
                nbMais --;
                break;
            default:
                break;
        }
    }
}
