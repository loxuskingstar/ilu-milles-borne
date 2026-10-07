package testsFonctionnels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {

    public static <T> void testerRassemblement(String nom, List<T> liste) {
        System.out.println("\n--- Test : " + nom + " ---");
        System.out.println("Initiale : " + liste);
        
        List<T> rassemblee = GestionCartes.rassembler(liste);
        System.out.println("Rapprochée : " + rassemblee);
        
        boolean valide = GestionCartes.verifierRassemblement(rassemblee);
        System.out.println("Rassemblement sans erreur ? " + valide);
    }

    public static void main(String[] args) {
        // Scénario de l'énoncé sur le jeu de cartes
        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }

        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        System.out.println("--- Test du Jeu de Cartes ---");
        System.out.println("Taille initiale : " + listeCartes.size());

        // Mélange
        listeCartes = GestionCartes.melanger(listeCartes);
        System.out.println("Liste mélangée sans erreur ? "
                + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

        // Rassemblement
        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println("Liste rassemblée sans erreur ? "
                + GestionCartes.verifierRassemblement(listeCartes));

        // Validation sur les listes d'exemples de l'énoncé
        testerRassemblement("Liste vide", new ArrayList<Integer>());
        testerRassemblement("Suite 1", Arrays.asList(1, 1, 2, 1, 3));
        testerRassemblement("Suite 2", Arrays.asList(1, 4, 3, 2));
        testerRassemblement("Suite 3", Arrays.asList(1, 1, 2, 3, 1));
    }
}
