package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PierreTest {

    @BeforeEach
    public  void initJFX() {
        // Initialisation de JavaFX pour les tests
        JFXPanel jfxPanel = new JFXPanel();
    }

    @Test
    public void testInterraction() throws IOException {
        Pierre pierre = new Pierre(1, 1);
        assertFalse(pierre.getEstMarchable());
        assertNotNull(pierre.getImage());

        pierre.interraction();

        assertTrue(pierre.getEstMarchable());
        assertNull(pierre.getImage());
    }
}