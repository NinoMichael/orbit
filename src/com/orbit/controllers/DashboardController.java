package com.orbit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    public Button btnStart;
    
    @FXML
    public Label titleCours;

    public MainAppController mainAppController;
    
    public void setMainAppController(MainAppController mainAppController) {
        this.mainAppController = mainAppController;
    }

    @FXML
    public void initialize() {
        if (btnStart != null) {
            btnStart.setOnAction(e-> mainAppController.loadCourseInterface());
        } else {
            System.out.println("btnStart is null!");
        }
    }
}
