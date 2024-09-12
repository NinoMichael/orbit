package com.orbit.models;

public class Lecon {
	public int id;
	public Module module;
	public int ordre;
	public String titre;
	public String contenu;
	public Ressource ressource;
	
	public Lecon(Module module, int ordre, String titre, String contenu, Ressource ressource) {
		this.module = module;
		this.ordre = ordre;
		this.titre = titre;
		this.contenu = contenu;
		this.ressource = ressource;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
	
}
