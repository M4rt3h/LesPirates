package pirates;

public class CarteMendiant extends CartePopularite{
	
	private int populariteDeCarte = -3;

	public CarteMendiant() {
		setNomCarte("Carte Mendiant");
		setDescription("Tu jettes une pièce à ton adversaire");
		setRarete("Rare");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n"
				+ description + "\n" + "l'adversaire perd " + String.valueOf(-populariteDeCarte) +" de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifPopularite(populariteDeCarte);
	}

}
