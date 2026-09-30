package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (!super.equals(obj)) {
	    	return false;
	    }
	    Probleme autre = (Probleme) obj;
	    return this.type.equals(autre.type);
	}


}
