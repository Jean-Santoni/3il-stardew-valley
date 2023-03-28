package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HerbeTest {
    private Herbe herbe;
    @BeforeEach
    public  void initJFX() {

        // Initialisation de JavaFX pour les tests

        JFXPanel jfxPanel = new JFXPanel();
        herbe = new Herbe(0, 0);
    }
    @Test
    void testInterraction() throws IOException {
        assertFalse(herbe.getEstMarchable());
        assertNotNull(herbe.getImage());

        herbe.interraction();

        assertTrue(herbe.getEstMarchable());
        assertNull(herbe.getImage());
    }
}