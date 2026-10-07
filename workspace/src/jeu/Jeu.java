package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
    private Sabot sabot;

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] cartesInitiales = jeuDeCartes.donnerCartes();
        List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, cartesInitiales);

        listeCartes = GestionCartes.melanger(listeCartes);

        Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);
        this.sabot = new Sabot(cartesMelangees);
    }

    public Sabot getSabot() {
        return this.sabot;
    }
}
