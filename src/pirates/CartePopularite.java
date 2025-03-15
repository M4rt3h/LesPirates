package pirates;

public class CartePopularite extends Carte {
	private boolean surJoueurActif;

	public CartePopularite(String nom, String description, int forcePOP, String rarete, boolean surJoueurActif) {
		setNomCarte(nom);
		setDescription(description);
		setPointPopulariteCarte(forcePOP);
		setRarete(rarete);
		this.surJoueurActif = surJoueurActif;
	}

	@Override
	public String carteToString() {
		String evolutionPOP;
		if (getPointPopulariteCarte() < 0) {
			evolutionPOP = "retire ";
		} else {
			evolutionPOP = "ajoute ";
		}
		if (surJoueurActif) {
			return nomCarte + " (" + rarete + ")\n" + description + "\n" + "La carte " + evolutionPOP
					+ String.valueOf(Math.abs(getPointPopulariteCarte())) + " de popularite" + "\n";
		} else {
			return nomCarte + " (" + rarete + ")\n" + description + "\n" + "La carte " + evolutionPOP
					+ String.valueOf(Math.abs(getPointPopulariteCarte())) + " de popularite" + "\n";
		}
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		if (surJoueurActif) {
			joueurCourant.modifPopularite(getPointPopulariteCarte());
		}
		else {
			joueurAdverse.modifPopularite(getPointPopulariteCarte());

		}
	}
}
