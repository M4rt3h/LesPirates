package pirates;

public class CarteMendiant extends CartePopularite{
	
	private int populariteDeCarte = -2;

	public CarteMendiant() {
		setNomCarte("Carte Collier");
		setDescription("Tu jettes une pièce à ton adversaire");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte +"\n"+ description + "\n" + "l'adversaire perd " + String.valueOf(-populariteDeCarte) +" de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifPopularite(populariteDeCarte);
	}

}
