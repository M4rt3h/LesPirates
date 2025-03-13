package pirates;

public class CarteMainDeFer extends CartePopularite {

	public CarteMainDeFer() {
		setNomCarte("Carte Main de fer");
		setDescription("Tu tapes du poing sur la table et remets ton equipage dans le rang");
		setPop(-1);
		setRarete("Commune");
		carteToString();
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(-1);
	}
}
