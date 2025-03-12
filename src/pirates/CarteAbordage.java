package pirates;

public class CarteAbordage extends CarteAttaque {

	public CarteAbordage() {
		setNomCarte("Carte abordage");
		setDescription("Ton equipage et toi abordez le navire adverse");
		setDegats(2);
		carteToString();
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(nbDegats);
	}
}