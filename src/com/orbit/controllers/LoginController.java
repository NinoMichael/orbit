package com.orbit.controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import com.orbit.dao.UtilisateurDao;
import com.orbit.models.Utilisateur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	public static Utilisateur sessionUser;
	
	@FXML
	public TextField inputIdentifiant;

	@FXML
	public PasswordField inputMdp;

    @FXML
    public Button btnNext;
    
    @FXML
    public Button btnAddAccount;

	private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    public void initialize() {
        btnNext.setOnAction(event -> {
            handleLogin();
        });
        
        btnAddAccount.setOnAction(event -> {
            try {
				switchToRegister();
			} catch (IOException e) {
				e.printStackTrace();
			}
        });
    }
    
    public void handleLogin() {
    	 String identifiant = inputIdentifiant.getText();
         String password = inputMdp.getText();

         if (identifiant.isEmpty() || password.isEmpty()) {
             System.out.println("L'identifiant et le mot de passe sont requis");
             return;
         }
         
        /*sessionUser = UtilisateurDao.isUtilisateurExiste(identifiant, password);
        if(sessionUser != null) {
        	LocalDateTime now = LocalDateTime.now();
            sessionUser.setLastLogged(now);
            UtilisateurDao.update(sessionUser);
        }*/
          
        try {
			switchToMainApp();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void switchToMainApp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/mainApp.fxml"));
        Scene loginScene = new Scene(loader.load());

        stage.setScene(loginScene);
    }
    
    private void switchToRegister() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/registerStepOne.fxml"));
        Scene registerScene = new Scene(loader.load());
        
        RegisterStepOneController stepOneController = loader.getController();
        
        stepOneController.setStage(stage);

        if (stage != null) {
            stage.setScene(registerScene);
        }
    }

}
