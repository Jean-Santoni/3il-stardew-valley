package com.stardew.stardewvalley;

public class Personnage {
    private static int posX;
    private static int posY;

    public static void initialiserPersonnage() {
        posX = 0;
        posY = 0;
    }

    public static int getPosX() {
        return posX;
    }

    public static int getPosY() {
        return posY;
    }

    public static void deplacerX(int x) {
        posX += x;
    }

    public static void deplacerY(int y) {
        posY += y;
    }

}
