package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    @BeforeEach
    public  void initJFX() {
        // Initialisation de JavaFX pour les tests
        Inventaire.initialiseInventaire();
        JFXPanel jfxPanel = new JFXPanel();


    }
    @Test
    void testAjouter() {
        // On ajoute 2 houblons à l'inventaire
        Inventaire.ajouter(Cultures.Houblon);
        Inventaire.ajouter(Cultures.Houblon);

        // On vérifie que le nombre de houblons est bien de 2
        assertEquals(2,  Inventaire.getNbCulture(Cultures.Houblon));
    }

    @Test
    void testRetirer() {
        // On retire 1 blé de l'inventaire
        Inventaire.retirer(Cultures.Blé);

        // On vérifie que le nombre de blés est bien de 0
        assertEquals(0,  Inventaire.getNbCulture(Cultures.Blé));
    }

    @Test
    void testAjouterArgent() {

        // On ajoute 100 crédits à l'inventaire
        Inventaire.ajouterArgent(100);

        // On vérifie que le montant d'argent est bien de 100
        assertEquals(100,  Inventaire.getArgent());
    }

    @Test
    void testRetirerArgent() {
        // On retire 50 crédits de l'inventaire
        Inventaire.retirerArgent(50);

        // On vérifie que le montant d'argent est bien de 50
        assertEquals(-50,  Inventaire.getArgent());
    }

    @Test
    void getNbCulture() {
    }
}