package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaisonInterieurTest {
    private MaisonInterieur maisonInterieur;

    @BeforeEach
    public void setUp() {
        JFXPanel jfxPanel = new JFXPanel();
        maisonInterieur = new MaisonInterieur();
    }

    @Test
    public void testDeplacementPersonnage() {
        int posXInitial = maisonInterieur.getPersonnage().getPosX();
        int posYInitial = maisonInterieur.getPersonnage().getPosY();

        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.RIGHT, false, false, false, false);

        maisonInterieur.setOnKeyPressed(new Clavier(maisonInterieur));
        maisonInterieur.fireEvent(keyEvent);

        int posXFinal = maisonInterieur.getPersonnage().getPosX();
        int posYFinal = maisonInterieur.getPersonnage().getPosY();

        Assertions.assertEquals(posXInitial + 1, posXFinal);
        Assertions.assertEquals(posYInitial, posYFinal);
    }
}
