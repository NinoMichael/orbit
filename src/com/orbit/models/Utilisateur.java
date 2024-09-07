package com.orbit.models;

import java.time.LocalDateTime;

public class Utilisateur {
	public int id;
	public String identifiant;
	public String email;
	public String mdp;
	public LocalDateTime dateInscription;
	public LocalDateTime LastLogged;
	
	public Utilisateur(String identifiant, String mdp) {
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	
	public Utilisateur(String identifiant, String email, String mdp) {
		this.identifiant = identifiant;
		this.email = email;
		this.mdp = mdp;
	}
	
	public Utilisateur(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
}	
