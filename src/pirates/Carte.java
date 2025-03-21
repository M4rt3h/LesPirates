package pirates;

public abstract class Carte {
	protected String description;
	protected String nomCarte;
	protected String rarete; // "Commune", "Rare", "Légendaire"

	public String getNomCarte() {
		return nomCarte;
	}

	protected void setRarete(String laRarete) {
		rarete = laRarete;
	}

	public String getRarete() {
		return rarete;
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