package com.orbit.models;

public class Module {
	public int id;
	public Cours cours;
	public int ordre;
	public String titre;
	public String description;
	
	public Module(Cours cours, int ordre, String titre, String description) {
		this.cours = cours;
		this.ordre = ordre;
		this.titre = titre;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
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
	
	
}
