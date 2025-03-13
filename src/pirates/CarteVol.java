package pirates;

public class CarteVol extends Carte {

	private IAffichage affichage = Jeu.getAffichage();

	public CarteVol(String nom, String description, String rarete) {
		setNomCarte(nom);
		setDescription(description);
		setRarete(rarete);
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description;
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		affichage.afficherMessage("Voici la main du joueur adverse :");
		affichage.afficherMain(joueurAdverse);
		affichage.afficherMessage("Entrez le numero de la carte que vous voulez récupérer dans la main adverse :");
		int numeroCarteAdverse = affichage.lireReponse();
		Carte carteAdverse = joueurAdverse.getCarte(numeroCarteAdverse);

		affichage.afficherMessage("Voici votre main :");
		affichage.afficherMain(joueurCourant);
		affichage.afficherMessage("Entrez le numero de la carte que vous voulez donner à l'adversaire :");
		int numeroCarteJoueur = affichage.lireReponse();
		Carte carteJoueur = joueurCourant.getCarte(numeroCarteJoueur);
		joueurCourant.definirCarte(numeroCarteJoueur, carteAdverse);
		joueurAdverse.definirCarte(numeroCarteAdverse, carteJoueur);

	}

}
