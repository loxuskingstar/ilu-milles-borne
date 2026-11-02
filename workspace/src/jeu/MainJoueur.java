package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {
    private List<Carte> cartes = new ArrayList<>();

    public void prendre(Carte carte) {
        cartes.add(carte);
    }

    public void jouer(Carte carte) {
        assert cartes.contains(carte) : "La carte n'est pas présente dans la main";
        cartes.remove(carte);
    }

    @Override
    public String toString() {
        return cartes.toString();
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartes.iterator();
    }
}