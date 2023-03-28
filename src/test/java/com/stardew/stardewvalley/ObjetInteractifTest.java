package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjetInteractifTest {
    @BeforeEach
    public  void initJFX() {
        // Initialisation de JavaFX pour les tests
        JFXPanel jfxPanel = new JFXPanel();
    }
    @Test
    void testConstructeur() {
        ObjetInteractif objetInteractif = new ObjetInteractif(1, 2, true);

        Assertions.assertEquals(1, objetInteractif.getPosX());
        Assertions.assertEquals(2, objetInteractif.getPosY());
        Assertions.assertTrue(objetInteractif.getEstMarchable());
    }

    @Test
    void testSetters() {
        ObjetInteractif objetInteractif = new ObjetInteractif(0, 0, false);

        objetInteractif.setPosX(1);
        Assertions.assertEquals(1, objetInteractif.getPosX());

        objetInteractif.setPosY(2);
        Assertions.assertEquals(2, objetInteractif.getPosY());

        objetInteractif.setMarchable(true);
        Assertions.assertTrue(objetInteractif.getEstMarchable());
    }

    @Test
    void testInterraction() {
        ObjetInteractif objetInteractif = new ObjetInteractif(0, 0, false);

        // Test que la méthode ne lève pas d'exception
        Assertions.assertDoesNotThrow(() -> objetInteractif.interraction());
    }
}