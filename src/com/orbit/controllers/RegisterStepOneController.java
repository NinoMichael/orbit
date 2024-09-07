package com.orbit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import com.orbit.dao.UtilisateurDao;
import com.orbit.models.Utilisateur;

public class RegisterStepOneController {
	public static Utilisateur user;
	
	@FXML
	public TextField inputIdentifiant;

	@FXML
	public TextField inputEmail;

	@FXML
	public PasswordField inputMdp;

    @FXML
    public Button btnNext;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        btnNext.setOnAction(event -> {
            handleRegister();
        });
    }
    
    public void handleRegister() {
    	 String identifiant = inputIdentifiant.getText();
         String email = inputEmail.getText();
         String password = inputMdp.getText();

         if (identifiant.isEmpty() || password.isEmpty()) {
             System.out.println("L'identifiant et le mot de passe sont requis");
             return;
         }
         
         if(email.isEmpty()) {
        	 Utilisateur utilisateur = new Utilisateur(identifiant, password);
             UtilisateurDao.createUtilisateur1(utilisateur);
             
             user = UtilisateurDao.getIdUtilisateurById();
         } else {
             Utilisateur utilisateur = new Utilisateur(identifiant, email, password);
             UtilisateurDao.createUtilisateur2(utilisateur);
             
             user = UtilisateurDao.getIdUtilisateurById();
         }
         
        try {
			switchToRegisterTwo();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void switchToRegisterTwo() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/registerStepTwo.fxml"));
        Scene registerScene = new Scene(loader.load());
        
        RegisterStepTwoController stepTwoController = loader.getController();
        stepTwoController.setStage(stage);

        if (stage != null) {
            stage.setScene(registerScene);
        }
    }
}
