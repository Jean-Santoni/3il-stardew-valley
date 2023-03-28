package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HerbeTest {
    @BeforeEach
    public  void initJFX() {
        // Initialisation de JavaFX pour les tests
        JFXPanel jfxPanel = new JFXPanel();
    }
    @Test
    public void testInterraction() throws IOException {
        Herbe herbe = new Herbe(0, 0);
        assertFalse(herbe.getEstMarchable());
        assertNotNull(herbe.getImage());

        herbe.interraction();

        assertTrue(herbe.getEstMarchable());
        assertNull(herbe.getImage());
    }

    @Test
    public void testConstructeur() throws IOException {
        Herbe herbe = new Herbe(5, 10);
        assertEquals(5, herbe.getPosX());
        assertEquals(10, herbe.getPosY());
        assertFalse(herbe.getEstMarchable());
        assertNotNull(herbe.getImage());
    }

}

