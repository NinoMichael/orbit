package com.orbit.controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import com.orbit.dao.NiveauDao;
import com.orbit.dao.ProfilUtilisateurDao;
import com.orbit.dao.UtilisateurDao;
import com.orbit.models.Niveau;
import com.orbit.models.ProfilUtilisateur;
import com.orbit.models.Utilisateur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LevelSituationController {
	
	 @FXML
	 public RadioButton option1;
	
	 @FXML
	 public RadioButton option2;
	
	 @FXML
	 public RadioButton option3;
	
	 @FXML
	 public RadioButton option4;
	
	 @FXML
	 public Button btnFinish;

    private Stage stage;

	public ToggleGroup dynamicGroup;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
    	this.dynamicGroup = new ToggleGroup();
        option1.setToggleGroup(dynamicGroup);
        option2.setToggleGroup(dynamicGroup);
        option3.setToggleGroup(dynamicGroup);
        option4.setToggleGroup(dynamicGroup);
    	
        btnFinish.setOnAction(event -> {
            handleFinish();
        });
    }
    
    private void handleFinish() {
        RadioButton selectedRadioButton = (RadioButton) dynamicGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedId = selectedRadioButton.getId(); 

            int level = getLevel(selectedId);
            
            Niveau niveau = NiveauDao.getIdNiveauById(level);
            
            ProfilUtilisateur profil =  ProfilUtilisateurDao.getIdProfilById();
            profil.setNiveau(niveau);
            ProfilUtilisateurDao.setNiveauProfil(profil);
            
            Utilisateur utilisateur = UtilisateurDao.getIdUtilisateurById();
            LocalDateTime now = LocalDateTime.now();
            utilisateur.setDateInscription(now);
            UtilisateurDao.update(utilisateur);
            
            try {
				switchToMainApp();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    public int getLevel(String radioButtonId) {
        switch (radioButtonId) {
            case "option1":
                return 1;
            case "option2":
                return 2;
            case "option3":
                return 3;
            case "option4":
                return 4;
            default:
                return 0; 
        }
    }

    public void switchToMainApp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/mainApp.fxml"));
        Scene registerScene = new Scene(loader.load());

        if (stage != null) {
            stage.setScene(registerScene);
        }
    }
}
