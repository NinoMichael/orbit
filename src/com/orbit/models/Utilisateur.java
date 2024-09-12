package com.orbit.models;

import java.time.LocalDateTime;

public class Utilisateur {
	public int id;
	public String identifiant;
	public String email;
	public String mdp;
	public LocalDateTime dateInscription;
	public LocalDateTime LastLogged;
	
	public Utilisateur(int id, String identifiant, String email, String mdp, LocalDateTime dateInscription, LocalDateTime lastLogged) {
		this.id = id;
		this.identifiant = identifiant;
		this.email = email;
		this.mdp = mdp;
		this.dateInscription = dateInscription;
		this.LastLogged = lastLogged;
	}
	
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

	public LocalDateTime getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDateTime dateInscription) {
		this.dateInscription = dateInscription;
	}

	public LocalDateTime getLastLogged() {
		return LastLogged;
	}

	public void setLastLogged(LocalDateTime lastLogged) {
		LastLogged = lastLogged;
	}
	
}	
