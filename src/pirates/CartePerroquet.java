package pirates;

public class CartePerroquet extends CartePopularite{
	private int populariteDeCarte = 1;
	public CartePerroquet() {
		setNomCarte("Carte Perroquet");
		setDescription("Ton perroquet clash la victime du navire");
		carteToString();
	}
	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(populariteDeCarte);
	}
}
