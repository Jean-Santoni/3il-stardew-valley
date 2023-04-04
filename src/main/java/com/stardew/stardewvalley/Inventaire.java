package com.stardew.stardewvalley;

/**
 * Inventaire du Joueur
 */
public class Inventaire {

    private static int nbHoublon;
    private static int nbBle;
    private static int nbPommeDeTerre;
    private static int nbTomate;
    private static int nbMais;
    private static int argent;

    /**
     * Permet d'ajouter une culture à l'inventaire
     * @param ajout la culture à ajouter
     */
    public static void ajouter(Cultures ajout) {
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

    /**
     * Permet de retirer une culture de l'inventaire
     * @param retirer la culture à retirer
     */
    public static void retirer(Cultures retirer) {
        switch (retirer){
            case Houblon:
                if(nbHoublon > 0){
                    nbHoublon = 0;
                }
                break;
            case Blé:
                if(nbBle >0){
                    nbBle = 0;
                }
                break;
            case PommeDeTerre:
                if(nbPommeDeTerre >0){
                    nbPommeDeTerre = 0;
                }
                break;
            case Tomate:
                if(nbTomate >0){
                    nbTomate = 0;
                }
                break;
            case Maïs:
                if(nbMais >0){
                    nbMais = 0;
                }
                break;
            default:
                break;
        }
    }

    /**
     * Permet d'ajouter de l'argent à l'inventaire
     * @param credit la somme à créditer
     */
    public static void ajouterArgent(int credit){
        argent += credit;
    }

    /**
     * Permet de retirer de l'argent à l'inventaire
     * @param debit la somme à débiter
     */
    public static void retirerArgent(int debit){
        argent -= debit;
    }

    /**
     * @return la somme d'argent actuelle du joueur
     */
    public static int getArgent(){return argent;}

    /**
     * Retourne le nombre d'une culture dans l'inventaire
     * @param c la culture à compter dans l'inventaire
     * @return le nombre de culture c dans l'inventaire
     */
    public static int getNbCulture(Cultures c) {
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

    /**
     * Permet d'initialiser l'inventaire
     */
    public static void initialiseInventaire(){
        nbHoublon= 0;
        nbBle= 0;
        nbPommeDeTerre= 0;
        nbTomate= 0;
        nbMais = 0;
        argent = 0;
    }

}
