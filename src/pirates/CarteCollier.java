package pirates;

public class CarteCollier extends CartePopularite {

	private int populariteDeCarte = -2;
	private int pvDeCarte = 1;

	public CarteCollier() {
		setNomCarte("Carte de collier");
		setDescription("Tu habilles ton costume de ton plus beau collier\nLa beauté est subjective ...");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "Gagne " + String.valueOf(pvDeCarte) + " PV\nPerd "
				+ String.valueOf(-populariteDeCarte) + " de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(populariteDeCarte);
		joueurCourant.modifVie(pvDeCarte);
	}

}
