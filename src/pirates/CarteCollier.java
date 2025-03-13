package pirates;

public class CarteCollier extends CartePopularite {

	public CarteCollier() {
		setNomCarte("Carte de collier");
		setDescription("Tu habilles ton costume de ton plus beau collier\nLa beauté est subjective ...");
		setRarete("Commune");
		setPointPopulariteCarte(-2);
		setPointAttaqueCarte(1);
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + "\n" + "Gagne " + String.valueOf(getPointAttaqueCarte())
				+ " PV\nPerd " + String.valueOf(-getPointPopulariteCarte()) + " de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(getPointPopulariteCarte());
		joueurCourant.modifVie(getPointAttaqueCarte());
	}

}
