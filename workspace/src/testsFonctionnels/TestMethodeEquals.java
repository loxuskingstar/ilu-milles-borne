package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {
	public void testEquals() {
		Borne borne1 = new Borne(25);
		Borne borne2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + borne1.equals(borne2));
		Attaque feuRouge1 = new Attaque(Type.FEU);
		Attaque feuRouge2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? " + feuRouge1.equals(feuRouge2));
		Parade feuVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identique ? " + feuRouge1.equals(feuVert));
		
	}
	
	public static void main(String[] args) {
		TestMethodeEquals testEquals = new TestMethodeEquals();
		testEquals.testEquals();
	}
}
