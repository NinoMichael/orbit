package com.orbit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.orbit.controllers.SplashController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le Splash Screen
        FXMLLoader splashLoader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/splash.fxml"));
        Parent splashRoot = splashLoader.load();
        
        SplashController splashController = splashLoader.getController();
        
        splashController.setStage(primaryStage);
        
        Scene splashScene = new Scene(splashRoot);
        primaryStage.setScene(splashScene);
        primaryStage.setTitle("OrbIT");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
