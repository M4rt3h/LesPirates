package pirates;

public class CarteAttaque extends Carte {
	protected int nbDegats = -1;

	protected void setDegats(int degats) {
		nbDegats = degats;
	}

	public CarteAttaque() {
		setNomCarte("Carte attaque simple");
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "Valeur attaque = " + String.valueOf(nbDegats) + "\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(nbDegats);
	}
}
