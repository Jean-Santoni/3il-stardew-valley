package com.stardew.stardewvalley;

/**
 * Classe Maison héritant d'ObjetInteractif
 *
 * @since le 22/03/2023
 * @version le 22/03/2023
 */
public class Maison extends ObjetInteractif {

    private boolean porte;

    public Maison(int pfPosX, int pfPosY,boolean porte) {
        super(pfPosX, pfPosY, false);
        this.porte=porte;
    }

    @Override
    public void interraction() {
        if(this.porte){
            System.out.println("C'est bon");
        }
    }

}
