package com.orbit.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

import com.orbit.dao.UtilisateurDao;

public class SplashController {

    @FXML
    public ImageView logoImage;

    @FXML
    public Label refCode;

    private Stage stage; 

    @FXML
    public void initialize() {
        new Thread(() -> {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                try {
					switchToRightInterface();
				} catch (IOException e) {
					e.printStackTrace();
				}
            });
        }).start();
    }

    private void changeSceneToIntro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/intro.fxml"));
        Scene introScene = new Scene(loader.load());

        IntroController introController = loader.getController();
        introController.setStage(stage);

        stage.setScene(introScene);
    }
    
    private void changeSceneToLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/mainApp.fxml"));
        Scene loginScene = new Scene(loader.load());
        
        MainAppController mainController = loader.getController();
        mainController.setStage(stage);

        stage.setScene(loginScene);
    }
    
    private void switchToRightInterface() throws IOException{
    	if(UtilisateurDao.isUtilisateurExiste()) {
    		changeSceneToIntro();
    	} else {
    		changeSceneToLogin();
    	}
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
