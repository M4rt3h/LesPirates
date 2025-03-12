package pirates;

public class CarteVol extends Carte {

	public CarteVol() {
		setNomCarte("Voler une carte");
		setDescription("Tu peux voler une carte de ton choix a ton adversaire\n");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description;
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		Affichage affichage = new Affichage();
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
