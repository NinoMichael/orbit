package com.orbit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class IntroController {

    @FXML
    public Button btnStart;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        btnStart.setOnAction(event -> {
            try {
                switchToRegister();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void switchToRegister() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/registerStepOne.fxml"));
        Scene registerScene = new Scene(loader.load());
        
        RegisterStepOneController stepOneController = loader.getController();
        
        stepOneController.setStage(stage);

        if (stage != null) {
            stage.setScene(registerScene);
        }
    }
}
