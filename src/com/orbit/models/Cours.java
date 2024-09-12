package com.orbit.models;

public class Cours {
	public int id;
	public Matiere matiere;
	public CategorieCours categorieCours;
	public double totalPoints;
	public Niveau niveau;
	
	public Cours(Matiere matiere, CategorieCours categorieCours, int totalPoints, Niveau niveau) {
		this.matiere = matiere;
		this.categorieCours = categorieCours;
		this.totalPoints = totalPoints;
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public CategorieCours getCategorieCours() {
		return categorieCours;
	}

	public void setCategorieCours(CategorieCours categorieCours) {
		this.categorieCours = categorieCours;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
	
	
}
