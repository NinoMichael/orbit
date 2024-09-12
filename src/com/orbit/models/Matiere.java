package com.orbit.models;

public class Matiere {
	public int id;
	public String titre;
	public String description;
	public String technologie;
	
	public Matiere(String titre, String description, String technologie) {
		this.titre = titre;
		this.description = description;
		this.technologie = technologie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}
	
	
}
