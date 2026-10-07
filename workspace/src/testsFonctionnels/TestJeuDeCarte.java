package testsFonctionnels;
import cartes.JeuDeCartes;


public class TestJeuDeCarte {
	private void testCheckCount() {
		JeuDeCartes jeu = new JeuDeCartes();
	    boolean resultat = jeu.checkCount();
	    if (resultat) {
	        System.out.println("Le jeu complet est valide.");
	    } else {
	        System.err.println("Le jeu est invalide");
	    }
	}
	
	public static void main(String[] args) {
	    TestJeuDeCarte testJeuDeCarte = new TestJeuDeCarte();
	    testJeuDeCarte.testCheckCount();
	}

}
