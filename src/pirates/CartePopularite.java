package pirates;

public class CartePopularite extends Carte {
	private int populariteDeCarte = 1;


	protected void setPop(int pop) {
		populariteDeCarte = pop;
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "La carte ajoute "+String.valueOf(populariteDeCarte) +" de popularite" + "\n";
	}
	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifPopularite(populariteDeCarte);
	}
}
