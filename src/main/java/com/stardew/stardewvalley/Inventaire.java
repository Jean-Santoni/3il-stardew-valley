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
    public static void ajouterArgent(int credit){
        argent += credit;
    }
    public static void retirerArgent(int debit){
        argent -= debit;
    }
    public static int getArgent(){return argent;}

    public static int getNbCulture(Cultivations c) {
        int result = 0;
        switch (c){
            case Houblon:
                result = nbHoublon;
                break;
            case Blé:
                result = nbBle;
                break;
            case PommeDeTerre:
                result = nbPommeDeTerre;
                break;
            case Tomate:
                result = nbTomate;
                break;
            case Maïs:
                result = nbMais;
                break;
            default:
                break;
        }
        return result;
    }
    public static void initialiseInventaire(){
      nbHoublon= 0;
      nbBle= 0;
      nbPommeDeTerre= 0;
      nbTomate= 0;
      nbMais = 0;
      argent = 0;
    }
}
