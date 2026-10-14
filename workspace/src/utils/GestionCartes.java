package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

    private static final Random RAND = new Random();

    public static <T> T extraire(List<T> liste) {
        if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne doit pas être vide.");
        }
        int index = RAND.nextInt(liste.size());
        return liste.remove(index);
    }

    public static <T> T extraireIterator(List<T> liste) {
        if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne doit pas être vide.");
        }
        int index = RAND.nextInt(liste.size());
        ListIterator<T> it = liste.listIterator();
        
        for (int i = 0; i <= index; i++) {
            it.next();
        }
        it.previous();
        T element = it.next();
        it.remove();
        return element;
    }

    public static <T> List<T> melanger(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        while (!liste.isEmpty()) {
            resultat.add(extraire(liste));
        }
        return resultat;
    }

    public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
        if (liste1.size() != liste2.size()) {
            return false;
        }
        for (T element : liste1) {
            if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
                return false;
            }
        }
        return true;
    }

    // d. rassembler les éléments identiques de manière consécutive
    public static <T> List<T> rassembler(List<T> liste) {
        List<T> resultat = new ArrayList<>();
        for (T element : liste) {
            if (!resultat.contains(element)) {
                int nbOccurrences = Collections.frequency(liste, element);
                for (int i = 0; i < nbOccurrences; i++) {
                    resultat.add(element);
                }
            }
        }
        return resultat;
    }

    public static <T> boolean verifierRassemblement(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            return true;
        }

        ListIterator<T> it1 = liste.listIterator();
        T ancienneValeur = null;

        while (it1.hasNext()) {
            T valeurCourante = it1.next();

            // S'il y a un changement de valeur
            if (ancienneValeur != null && !valeurCourante.equals(ancienneValeur)) {
                // On crée un deuxième itérateur pour balayer le reste de la liste
                ListIterator<T> it2 = liste.listIterator(it1.nextIndex());
                while (it2.hasNext()) {
                    // Si on retrouve l'ancienne valeur plus loin ce n'est pas rassemblé
                    if (it2.next().equals(ancienneValeur)) {
                        return false;
                    }
                }
            }
            ancienneValeur = valeurCourante;
        }
        return true;
    }
}
