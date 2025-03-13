package pirates;

public class CartePvEtPopularite extends Carte {

	public CartePvEtPopularite(String nom, String description, String rarete, int forcePV, int forcePOP) {
		setNomCarte(nom);
		setDescription(description);
		setRarete(rarete);
		setPointPopulariteCarte(forcePOP);
		setPointAttaqueCarte(forcePV);

	}

	@Override
	public String carteToString() {
		String evolutionPV;
		String evolutionPOP;
		if (getPointAttaqueCarte() < 0) {
			evolutionPV = "perd ";
		} else {
			evolutionPV = "gagne ";
		}
		if (getPointPopulariteCarte() < 0) {
			evolutionPOP = "perd ";
		} else {
			evolutionPOP = "gagne ";
		}
		return nomCarte + " (" + rarete + ")\n" + description + "\n" + "L'adversaire " + evolutionPV
				+ String.valueOf(Math.abs(getPointAttaqueCarte())) + " PV\nTu " + evolutionPOP
				+ String.valueOf(Math.abs(getPointPopulariteCarte())) + " de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(getPointAttaqueCarte());
		joueurCourant.modifPopularite(getPointPopulariteCarte());

	}

}
