package pirates;

public class CartePopularite extends Carte {
	private boolean quelJoueur;

	public CartePopularite(String nom, String description,int forcePOP, String rarete, boolean surJoueurActif) {
		setNomCarte(nom);
		setDescription(description);
		setPointPopulariteCarte(forcePOP);
		setRarete(rarete);
		this.quelJoueur = surJoueurActif;
	}

	@Override
	public String carteToString() {
		String evolutionPOP;
		if (getPointAttaqueCarte() < 0) {
			evolutionPV = "perd ";
		}
		if (quelJoueur)
		return nomCarte + " (" + rarete + ")\n" + description + "\n" + "La carte ajoute "
				+ String.valueOf(populariteDeCarte) + " de popularite" + "\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(populariteDeCarte);
	}
}
