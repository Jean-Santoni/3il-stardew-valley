package com.stardew.stardewvalley;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.BeforeClass;
import javafx.application.Application;


import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {
    @BeforeEach
    public  void initJFX() {
        // Initialisation de JavaFX pour les tests
        JFXPanel jfxPanel = new JFXPanel();
    }
    @Test
    void creationPersonnage() throws IOException {
        Personnage p = new Personnage();
        assertEquals(0,p.getPosX());
        assertEquals(0,p.getPosY());
    }

    @Test
    void setPosX() throws IOException {
        Personnage p = new Personnage();
        p.setPosX(1);
        assertEquals(1,p.getPosX());
    }

    @Test
    void setPosY() throws IOException {
        Personnage p = new Personnage();
        p.setPosY(10);
        assertEquals(10,p.getPosY());
    }
}