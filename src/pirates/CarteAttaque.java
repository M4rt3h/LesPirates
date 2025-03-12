package pirates;

public class CarteAttaque extends Carte {
	protected int nbDegats = -1;

	protected void setDegats(int degats) {
		nbDegats = degats;
	}

	public CarteAttaque() {
		setNomCarte("Carte attaque simple");
		setDescription("Tu jettes un cailloux sur ton adversaire...");

	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "L'adversaire perd " + String.valueOf(-nbDegats) + " PV\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(nbDegats);
	}
}
