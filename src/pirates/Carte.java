package pirates;

public abstract class Carte {
	
	private String nomCarte;
	
	protected String getNomCarte() {
		return nomCarte;
	}
	
	public abstract String decrireCarte();
	
	public abstract String carteToString();
}
