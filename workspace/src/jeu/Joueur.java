package jeu;

import cartes.Probleme;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	
	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (!super.equals(obj)) {
	    	return false;
	    }
	    Probleme autre = (Probleme) obj;
	    return this.type.equals(autre.type);
	}
}
