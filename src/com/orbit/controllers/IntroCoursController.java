package com.orbit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IntroCoursController {
    @FXML
    public Label titleCours;
	
	public MainAppController mainAppController;
	
	 public void setMainAppController(MainAppController mainAppController) {
	        this.mainAppController = mainAppController;
	 }

	 @FXML
    public void initialize() {
	 
    }
}
