package pirates;

public class CarteCoupDeSabre extends Carte {
	private int nbDegats = -4;
	private int populariteDeCarte = 2;

	public CarteCoupDeSabre() {
		setNomCarte("Carte coup de sabre");
		setDescription("Muni de ton fameux sabre, tu assenes un coup digne de ta legende a ton adversaire");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte +"\n"+ description + "\n" + "Valeur attaque = " + String.valueOf(nbDegats) +"\n"+ "Regain de " + String.valueOf(populariteDeCarte) +" de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(populariteDeCarte);
		joueurAdverse.modifVie(nbDegats);
	}
}