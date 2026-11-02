package jeu;

import cartes.Probleme;
import cartes.Carte;

public class Joueur {
    private String nom;
    private ZoneDeJeu zone;
    private MainJoueur main;

    public Joueur(String nom, ZoneDeJeu zone) {
        this.nom = nom;
        this.zone = zone;
        this.main = new MainJoueur();
    }
    
    public MainJoueur getMain() {
        return main;
    }

    public void donner(Carte carte) {
        this.main.prendre(carte);
    }

    public Carte prendreCarte(Sabot sabot) {
        if (sabot.estVide()) {
            return null;
        }
        Carte carte = sabot.piocher();
        this.donner(carte);
        return carte;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Joueur autre = (Joueur) obj;
        return this.nom.equals(autre.nom);
    }
        
    public int donnerKmParcourus() {
        return zone.donnerKmParcourus();
    }

    public void deposer(Carte c) {
        zone.deposer(c);
    }
    
    public boolean estDepotAutorise(Carte carte) {
        return zone.estDepotAutorise(carte);
    }
}
