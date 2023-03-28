package com.stardew.stardewvalley;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.concurrent.CountDownLatch;

public class PlayerSonTest {
    private static MediaPlayer m;

    public static void playSon(String str) {
        File f = new File(str);
        Media a = new Media(f.toURI().toString());
        m = new MediaPlayer(a);
        m.play();
    }

    @Test
    public void testPlaySon() throws InterruptedException {
        // Initialisation de l'environnement JavaFX
        CountDownLatch latch = new CountDownLatch(1);
        Platform.setImplicitExit(false);
        new JFXPanel();
        Platform.runLater(latch::countDown);
        latch.await();

        // Test du son
        String file = "Son/venteEffectuee.wav";
        playSon(file);
        Thread.sleep(5000);
        m.stop();
    }
}

