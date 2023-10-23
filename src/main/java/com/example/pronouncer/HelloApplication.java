package com.example.pronouncer;

import com.example.pronouncer.model.*;
import com.example.pronouncer.scene.Key;
import com.example.pronouncer.scene.KeyStroke;
import com.example.pronouncer.scene.Scene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.Clipboard;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// TODO
//  add label displaying current clipboard value
public class HelloApplication extends Application {
    private final ExecutorService threadPool = Executors.newSingleThreadExecutor();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Browser defaultBrowser = new CambridgeBrowser(Pronunciation.AMERICAN);
        HelloController controller = fxmlLoader.getController();
        controller.addItemToListView(defaultBrowser);
        PronunciationHolder pronunciationHolder = new PronunciationHolder(new PronunciationHolderModel(), defaultBrowser);

        scene.addKeyStrokeListener(new KeyStroke(Key.OPTION, Key.C), keyStroke -> {
            Platform.runLater(() -> {
                String word = Clipboard.getSystemClipboard().getString().replace("\n", "").toLowerCase();
                threadPool.execute(() -> {
                    Media pronunciation = pronunciationHolder.getSound(word);
                    if (pronunciation != null) {
                        MediaPlayer mediaPlayer = new MediaPlayer(pronunciation);
                        mediaPlayer.play();
                    }
                });
            });
        });
    }

    public static void main(String[] args) {
        launch();
    }
}