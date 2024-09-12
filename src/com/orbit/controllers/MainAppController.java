package com.orbit.controllers;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainAppController {

    @FXML
    public AnchorPane AccountContainer, profilContainer, dashboardPane, communityContainer, progressionContainer, settingContainer, courseContainer;
    
    @FXML
    public Pane optionAccountContainer;

    @FXML
    public Label textLogout, confirmLogout, loginUser;

    @FXML
    public BorderPane mainPane;

    @FXML
    public Rectangle rectangle1, rectangle2, rectangle3, headerDialog;

    @FXML
    public Button cancelLogout, btnStart, acceptLogout;

    @FXML
    public DialogPane dialogLogoutContainer;

    @FXML
    public ImageView infoDialog, communityIcon, houseIcon, progressionIcon, settingIcon, courseIcon;

    public Stage stage;

    // Méthode pour définir le stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Initialisation du contrôleur
    @FXML
    public void initialize() throws URISyntaxException {
        initializeUIComponents();
        //loginUser.setText(LoginController.sessionUser.getIdentifiant());

        configureContainers();
        configureIcons();
        configureLogoutDialog();

        loadCourseInterface();
        loadDashboardInterface();
    }

    // Configuration initiale des éléments de l'interface utilisateur
    public void initializeUIComponents() {
        dialogLogoutContainer.setVisible(false);
        confirmLogout.setVisible(false);
        headerDialog.setVisible(false);
        cancelLogout.setVisible(false);
        acceptLogout.setVisible(false);
        infoDialog.setVisible(false);
        unsetBlackOverlay();
        hideAccountContainer();
    }

    // Gérer la visibilité du conteneur de compte
    public void hideAccountContainer() {
        optionAccountContainer.setVisible(false);
        profilContainer.setOnMouseClicked(event -> optionAccountContainer.setVisible(!optionAccountContainer.isVisible()));
    }

    // Configuration des conteneurs avec comportement de "mouseover"
    public void configureContainers() {
        configureContainerVisibility(communityIcon, communityContainer);
        configureContainerVisibility(progressionIcon, progressionContainer);
        configureContainerVisibility(settingIcon, settingContainer);
        configureContainerVisibility(courseIcon, courseContainer);
    }

    // Méthode générique pour configurer la visibilité des conteneurs
    public void configureContainerVisibility(ImageView icon, AnchorPane container) {
        container.setVisible(false);
        icon.setOnMouseEntered(event -> container.setVisible(true));
        container.setOnMouseExited(event -> container.setVisible(false));
    }

    // Configuration des événements d'icônes
    public void configureIcons() {
        houseIcon.setOnMouseClicked(event -> {
			try {
				loadDashboardInterface();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        courseIcon.setOnMouseClicked(event -> loadCourseInterface());
    }

    // Configuration de la boîte de dialogue de déconnexion
    public void configureLogoutDialog() {
        textLogout.setOnMouseClicked(event -> showLogoutDialog());
        acceptLogout.setOnAction(event -> performLogout());
        cancelLogout.setOnAction(event -> hideLogoutDialog());
    }

    // Afficher la boîte de dialogue de déconnexion
    public void showLogoutDialog() {
        setBlackOverlay();
        dialogLogoutContainer.setVisible(true);
        confirmLogout.setVisible(true);
        headerDialog.setVisible(true);
        cancelLogout.setVisible(true);
        acceptLogout.setVisible(true);
        infoDialog.setVisible(true);
    }

    // Cacher la boîte de dialogue de déconnexion
    public void hideLogoutDialog() {
        dialogLogoutContainer.setVisible(false);
        confirmLogout.setVisible(false);
        headerDialog.setVisible(false);
        cancelLogout.setVisible(false);
        acceptLogout.setVisible(false);
        infoDialog.setVisible(false);
        unsetBlackOverlay();
        optionAccountContainer.setVisible(false);
    }

    // Effectuer la déconnexion
    public void performLogout() {
        try {
            switchToLogin();
            //LoginController.sessionUser = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBlackOverlay() {
        rectangle1.setVisible(true);
        rectangle2.setVisible(true);
        rectangle3.setVisible(true);
    }

    public void unsetBlackOverlay() {
        rectangle1.setVisible(false);
        rectangle2.setVisible(false);
        rectangle3.setVisible(false);
    }

    // Charger l'interface des cours
    public void loadCourseInterface() {
    	URL fxmlLocation = getClass().getResource("/com/orbit/resources/fxml/introCours.fxml");
        try {
            
            if (fxmlLocation != null) {
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                ScrollPane content = loader.load();
                
                AccountContainer.getChildren().clear();
                AccountContainer.getChildren().add(content);
                remakeAccountContainer();
            } else {
                System.out.println("introCours.fxml not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Charger l'interface du tableau de bord
    public void loadDashboardInterface() throws URISyntaxException {  
    	URL fxmlLocation = getClass().getResource("/com/orbit/resources/fxml/dashboard.fxml");
        try {
            
            if (fxmlLocation != null) {
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                AnchorPane content = loader.load();
                
                DashboardController dashboardController = loader.getController();
                dashboardController.setMainAppController(this);
                
                AccountContainer.getChildren().clear();
                AccountContainer.getChildren().add(content);
                remakeAccountContainer();
            } else {
                System.out.println("dashboard.fxml not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ajouter des éléments récurrents au conteneur
    public void remakeAccountContainer() {
        AccountContainer.getChildren().addAll(optionAccountContainer, communityContainer, progressionContainer, settingContainer, courseContainer, rectangle2, dialogLogoutContainer, headerDialog, confirmLogout, acceptLogout, cancelLogout, infoDialog);
    }

    // Passer à la scène de connexion
    public void switchToLogin() throws IOException {
        try {
            Stage stage = (Stage) acceptLogout.getScene().getWindow();
            if (stage != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/orbit/resources/fxml/login.fxml"));
                Scene loginScene = new Scene(loader.load());
                LoginController loginController = loader.getController();
                loginController.setStage(stage);
                stage.setScene(loginScene);
                stage.show();
            } else {
                System.out.println("Stage is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
