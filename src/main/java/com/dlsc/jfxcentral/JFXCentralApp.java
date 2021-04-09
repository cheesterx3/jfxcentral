package com.dlsc.jfxcentral;

import fr.brouillard.oss.cssfx.CSSFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JFXCentralApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView(JFXCentralApp.class.getResource("duke-animation.gif").toExternalForm());
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);

        AudioClip plonkSound = new AudioClip(JFXCentralApp.class.getResource("sound.wav").toExternalForm());
        plonkSound.play();

        StackPane stackPane = new StackPane(imageView);

        Scene scene = new Scene(stackPane);
        scene.getStylesheets().add(JFXCentralApp.class.getResource("styles.css").toExternalForm());
        scene.setFill(Color.rgb(25,110,145));

        stackPane.setOnMouseClicked(evt -> scene.setRoot(new RootPane()));

        CSSFX.start();

        primaryStage.setScene(scene);
        primaryStage.setWidth(1200);
        primaryStage.setHeight(900);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("JFXCentral");
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
