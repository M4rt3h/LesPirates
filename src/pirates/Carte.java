package pirates;

public abstract class Carte {
	protected String description;
	protected String nomCarte;

	public String getNomCarte() {
		return nomCarte;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	protected String donnerDescription() {
		return description;
	}

	public abstract String carteToString();

	public abstract void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse);


}