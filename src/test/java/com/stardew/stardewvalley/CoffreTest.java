package com.stardew.stardewvalley;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ChoiceDialog;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CoffreTest {
    @Test
    public void testInterraction() throws IOException {
        // Initialisation des données nécessaires pour le test
        Coffre coffre = new Coffre(0, 0);

        // Exécution de la méthode à tester
        coffre.interraction();

        // Vérification des résultats
        assertTrue(Inventaire.getNbCulture() > 0);
    }

    @Test
    public void testValidationVendre() {
        // Initialisation des données nécessaires pour le test
        Coffre coffre = new Coffre(0, 0);

        // Exécution de la méthode à tester
        Platform.runLater(() -> {
            new JFXPanel(); // Initialisation de JavaFX pour les tests

            coffre.validationVendre(true);
            ChoiceDialog<Cultivations> dialog = (ChoiceDialog<Cultivations>) DialogsHelper.getPrivateField(coffre, "cDial");
            dialog.setResult(Cultivations.Houblon);
        });

        // Vérification des résultats
        assertTrue(Inventaire.getArgent() >= 10);
    }

    @Test
    public void testVendre() {
        // Initialisation des données nécessaires pour le test
        Coffre coffre = new Coffre(0, 0);
        Inventaire.ajouterCulture(Cultivations.Houblon);

        // Exécution de la méthode à tester
        coffre.vendre(Cultivations.Houblon);

        // Vérification des résultats
        assertEquals(0, Inventaire.getNbCulture());
        assertEquals(10, Inventaire.getArgent());
    }

}