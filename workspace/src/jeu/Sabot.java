package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import cartes.Carte;

public class Sabot implements Iterable<Carte> {

    private Carte[] cartes;
    private int nbCartes;
    private int nombreOperations = 0;

    public Sabot(Carte[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    // 1.a
    public boolean estVide() {
        return nbCartes == 0;
    }

    // 1.b
    public void ajouterCarte(Carte carte) {
        if (nbCartes >= cartes.length) {
            throw new ArrayIndexOutOfBoundsException("Capacité maximale du sabot atteinte.");
        }
        cartes[nbCartes++] = carte;
        nombreOperations++;
    }

    public Carte piocher() {
        Iterator<Carte> it = iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Le sabot est vide.");
        }
        Carte premiereCarte = it.next();
        it.remove();
        return premiereCarte;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new Iterateur();
    }

    private class Iterateur implements Iterator<Carte> {
        private int curseur = 0;
        private boolean nextEffectue = false;
        private int nombreOperationsAttendu = nombreOperations;

        private void verificationConcurrence() {
            if (nombreOperations != nombreOperationsAttendu) {
                throw new ConcurrentModificationException("Modification concurrente détectée !");
            }
        }

        @Override
        public boolean hasNext() {
            return curseur < nbCartes;
        }

        @Override
        public Carte next() {
            verificationConcurrence();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Carte c = cartes[curseur++];
            nextEffectue = true;
            return c;
        }

        @Override
        public void remove() {
            verificationConcurrence();
            if (!nextEffectue) {
                throw new IllegalStateException("Impossible de supprimer sans appel préalable à next().");
            }

            for (int i = curseur - 1; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i + 1];
            }
            cartes[nbCartes - 1] = null; 
            nbCartes--;
            curseur--;
            nextEffectue = false;
            nombreOperations++;
            nombreOperationsAttendu++;
        }
    }
}