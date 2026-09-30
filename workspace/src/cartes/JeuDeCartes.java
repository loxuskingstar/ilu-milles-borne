package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = new Configuration[] {
            // Bornes
            new Configuration(new Borne(25), 10),
            new Configuration(new Borne(50), 10),
            new Configuration(new Borne(75), 10),
            new Configuration(new Borne(100), 12),
            new Configuration(new Borne(200), 4),
            // Limites de vitesse
            new Configuration(new DebutLimite(), 4),
            new Configuration(new FinLimite(), 6),
            // Parades
            new Configuration(new Parade(Type.FEU), 14),
            new Configuration(new Parade(Type.ESSENCE), 6),
            new Configuration(new Parade(Type.CREVAISON), 6),
            new Configuration(new Parade(Type.ACCIDENT), 6),
            // Attaques
            new Configuration(new Attaque(Type.FEU), 5),
            new Configuration(new Attaque(Type.ESSENCE), 3),
            new Configuration(new Attaque(Type.CREVAISON), 3),
            new Configuration(new Attaque(Type.ACCIDENT), 3),
            // Bottes
            new Configuration(new Botte(Type.FEU), 1),
            new Configuration(new Botte(Type.ESSENCE), 1),
            new Configuration(new Botte(Type.CREVAISON), 1),
            new Configuration(new Botte(Type.ACCIDENT), 1)
    };

    private static class Configuration {
        private int nbExemplaires;
        private Carte carte;

        private Configuration(Carte carte, int nbExemplaires) {
            this.carte = carte;
            this.nbExemplaires = nbExemplaires;
        }

        public Carte getCarte() {
            return carte;
        }

        public int getNbExemplaires() {
            return nbExemplaires;
        }
    }

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder("JEU :\n\n");
        for (Configuration config : typesDeCartes) {
            sb.append(config.getNbExemplaires());
            sb.append(" ");
            sb.append(config.getCarte().toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Carte[] donnerCartes() {
        int totalCartes = 0;
        for (Configuration config : typesDeCartes) {
            totalCartes += config.getNbExemplaires();
        }

        Carte[] deck = new Carte[totalCartes];
        int index = 0;

        for (Configuration config : typesDeCartes) {
            for (int i = 0; i < config.getNbExemplaires(); i++) {
                deck[index++] = config.getCarte();
            }
        }

        return deck;
    }
    
    public boolean checkCount() {
    	Carte[] deck = donnerCartes();
    }
    
    public void main() {
    	Carte[] deck = donnerCartes();
    	for (int i=0; i<deck.length;i++) {
    		System.out.println("Carte : " + deck[i].toString());
    	}
    }
}