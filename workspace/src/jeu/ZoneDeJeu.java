package jeu;

import java.util.ArrayList;
import java.util.List;
import cartes.Carte;
import cartes.Limite;
import cartes.FinLimite;
import cartes.Bataille;
import cartes.Borne;
import cartes.Parade;
import cartes.DebutLimite;
import cartes.Attaque;

public class ZoneDeJeu {
    private List<Limite> limites = new ArrayList<>();
    private List<Bataille> batailles = new ArrayList<>();
    private List<Borne> bornes = new ArrayList<>();
    
    public int donnerLimitationVitesse() {
        if (limites.isEmpty() || limites.get(limites.size() - 1) instanceof FinLimite) {
            return 200;
        }
        return 50;
    }
    
    public int donnerKmParcourus() {
        int total = 0;
        for (Borne borne : bornes) {
            total += borne.getKm();
        }
        return total;
    }
    
    public void deposer(Carte c) {
        if (c instanceof Borne) {
            bornes.add((Borne) c);
        } else if (c instanceof Limite) {
            limites.add((Limite) c);
        } else if (c instanceof Bataille) {
            batailles.add((Bataille) c);
        }
    }
    
    public boolean peutAvancer() {
        if (batailles.isEmpty()) {
            return false;
        }
        Bataille sommet = batailles.get(batailles.size() - 1);
        return sommet.equals(Cartes.FEU_VERT);
    }

    private boolean estDepotFeuVertAutorise() {
        if (batailles.isEmpty()) {
            return true;
        }
        Bataille sommet = batailles.get(batailles.size() - 1);
        if (sommet.equals(Cartes.FEU_ROUGE)) {
            return true;
        }
        return sommet instanceof Parade && !sommet.equals(Cartes.FEU_VERT);
    }

    private boolean estDepotBorneAutorise(Borne borne) {
        return peutAvancer() 
                && borne.getKm() <= donnerLimitationVitesse() 
                && (donnerKmParcourus() + borne.getKm() <= 1000);
    }

    private boolean estDepotLimiteAutorise(Limite limite) {
        if (limite instanceof DebutLimite) {
            return limites.isEmpty() || limites.get(limites.size() - 1) instanceof FinLimite;
        } else if (limite instanceof FinLimite) {
            return !limites.isEmpty() && limites.get(limites.size() - 1) instanceof DebutLimite;
        }
        return false;
    }

    private boolean estDepotBatailleAutorise(Bataille bataille) {
        if (bataille instanceof Attaque) {
            return peutAvancer();
        } else if (bataille instanceof Parade) {
            if (bataille.equals(Cartes.FEU_VERT)) {
                return estDepotFeuVertAutorise();
            } else {
                if (batailles.isEmpty()) {
                    return false;
                }
                Bataille sommet = batailles.get(batailles.size() - 1);
                return sommet instanceof Attaque && sommet.getType().equals(bataille.getType());
            }
        }
        return false;
    }

    public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Borne) {
            return estDepotBorneAutorise((Borne) carte);
        } else if (carte instanceof Limite) {
            return estDepotLimiteAutorise((Limite) carte);
        } else if (carte instanceof Bataille) {
            return estDepotBatailleAutorise((Bataille) carte);
        }
        return false;
    }
}