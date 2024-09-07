package com.orbit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

import com.orbit.dao.ProfilUtilisateurDao;
import com.orbit.models.ProfilUtilisateur;

public class RegisterStepTwoController {
	@FXML
	public TextField inputNom;

	@FXML
	public DatePicker inputDate;

	@FXML
	public TextField inputPays;

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
    	 String nom = inputNom.getText();
    	 LocalDate naissance = inputDate.getValue();
         String pays = inputPays.getText();

         if (nom.isEmpty() || pays.isEmpty()) {
             System.out.println("Information incomplète");
             return;
         }
         
         ProfilUtilisateur profil = new ProfilUtilisateur(RegisterStepOneController.user, nom, naissance, pays);
         ProfilUtilisateurDao.createProfil(profil);
         
        try {
			switchToLevel();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void switchToLevel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/levelSituation.fxml"));
        Scene registerScene = new Scene(loader.load());

        if (stage != null) {
            stage.setScene(registerScene);
        }
    }
}
