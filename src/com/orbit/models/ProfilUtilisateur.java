package com.orbit.models;

import java.time.LocalDate;

public class ProfilUtilisateur {
	public int id;
	public Utilisateur utilisateur;
	public String nom;
	public LocalDate naissance;
	public String pays;
	public String biographie;
	public Niveau niveau;

	public ProfilUtilisateur (Utilisateur utilisateur, String nom, LocalDate naissance, String pays) {
		this.utilisateur = utilisateur;
		this.nom = nom;
		this.naissance = naissance;
		this.pays = pays;
	}
	
	public ProfilUtilisateur(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public Niveau getNiveau() {
		return niveau;
	}
	
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

}
