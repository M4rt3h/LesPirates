package pirates;

public class CarteVol extends Carte {

	public CarteVol() {
		setNomCarte("Voler une carte");
		setDescription("Tu peux voler une carte de ton adversaire mais attention ..." + "\n...au hasard");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description;
	}

}
