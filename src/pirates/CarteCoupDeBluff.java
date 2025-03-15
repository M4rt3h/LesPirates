package pirates;

public class CarteCoupDeBluff extends Carte {
	private IAffichage affichage = Jeu.getAffichage();

	public CarteCoupDeBluff(String nom, String description, String rarete) {
		this.nomCarte = nom;
		this.description = description;
		this.rarete = rarete;
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ") \n" + description;
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		int popJoueurCourant = joueurCourant.getPopularite();
		int popJoueurAdverse = joueurAdverse.getPopularite();
		int echangeDePop = popJoueurCourant;
		joueurCourant.setPopularite(popJoueurAdverse);
		joueurAdverse.setPopularite(echangeDePop);
	}

}
