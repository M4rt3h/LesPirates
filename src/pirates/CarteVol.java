package pirates;

public class CarteVol extends Carte {

	private IAffichage affichage = Jeu.getAffichage();
	private int mode = 0;

	public CarteVol(String nom, String description, String rarete, int mode) {
		setNomCarte(nom);
		setDescription(description);
		setRarete(rarete);
		setMode(mode);
	}

	private void setMode(int mode) {
		this.mode = mode;
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description;
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		int numeroCarteAdverse = -1;
		int numeroCarteJoueur = -1;
		if (mode == 1) {
			affichage.afficherMessage("Voici la main du joueur adverse :");
			affichage.afficherMain(joueurAdverse);
			affichage.afficherMessage("Entrez le numero de la carte que vous voulez récupérer dans la main adverse :");
			while (numeroCarteAdverse < 0 && numeroCarteAdverse > 4) {
				numeroCarteAdverse = affichage.lireReponse();
				affichage.afficherMessage(
						"Ce n'est pas un choix possible.\n Saisissez un chiffre compris entre 1 et 5.");
			}
			Carte carteAdverse = joueurAdverse.getCarte(numeroCarteAdverse);

			affichage.afficherMessage("Voici votre main :");
			affichage.afficherMain(joueurCourant);
			affichage.afficherMessage("Entrez le numero de la carte que vous voulez donner à l'adversaire :");
			while (numeroCarteAdverse < 0 && numeroCarteAdverse > 4) {
				numeroCarteJoueur = affichage.lireReponse();
				affichage.afficherMessage(
						"Ce n'est pas un choix possible.\n Saisissez un chiffre compris entre 1 et 5.");
			}
			Carte carteJoueur = joueurCourant.getCarte(numeroCarteJoueur);
			joueurCourant.definirCarte(numeroCarteJoueur, carteAdverse);
			joueurAdverse.definirCarte(numeroCarteAdverse, carteJoueur);
		} else if (mode == 2) {
			affichage.afficherMessage("Voici les noms des cartes de la main de " + joueurAdverse.getNom());
			for (int i = 0; i < 5; i++) {
				affichage.afficherMessage("Carte 1\n" + joueurAdverse.getCarte(i) + "\n");
			}
			affichage.afficherMessage("Entrez le numero de la carte que vous voulez récupérer dans la main adverse :");
			while (numeroCarteAdverse < 0 && numeroCarteAdverse > 4) {
				numeroCarteAdverse = affichage.lireReponse();
				affichage.afficherMessage(
						"Ce n'est pas un choix possible.\n Saisissez un chiffre compris entre 1 et 5.");
			}
			Carte carteAdverse = joueurAdverse.getCarte(numeroCarteAdverse);

			affichage.afficherMessage("Voici votre main :");
			affichage.afficherMain(joueurCourant);
			affichage.afficherMessage("Entrez le numero de la carte que vous voulez donner à l'adversaire :");
			while (numeroCarteAdverse < 0 && numeroCarteAdverse > 4) {
				numeroCarteJoueur = affichage.lireReponse();
				affichage.afficherMessage(
						"Ce n'est pas un choix possible.\n Saisissez un chiffre compris entre 1 et 5.");
			}
			Carte carteJoueur = joueurCourant.getCarte(numeroCarteJoueur);
			joueurCourant.definirCarte(numeroCarteJoueur, carteAdverse);
			joueurAdverse.definirCarte(numeroCarteAdverse, carteJoueur);
		} else if (mode == 3) {
			affichage.afficherMessage("Vous n'avez pas le luxe de choisir la carte adverse.");
			numeroCarteAdverse = (int) (Math.random() * 5);
			Carte carteAdverse = joueurAdverse.getCarte(numeroCarteAdverse);

			affichage.afficherMessage("Voici votre main :");
			affichage.afficherMain(joueurCourant);
			affichage.afficherMessage("Entrez le numero de la carte que vous voulez donner à l'adversaire :");
			while (numeroCarteAdverse < 0 && numeroCarteAdverse > 4) {
				numeroCarteAdverse = affichage.lireReponse();
				affichage.afficherMessage(
						"Ce n'est pas un choix possible.\n Saisissez un chiffre compris entre 1 et 5.");
			}
			numeroCarteJoueur = affichage.lireReponse();
			Carte carteJoueur = joueurCourant.getCarte(numeroCarteJoueur);
			joueurCourant.definirCarte(numeroCarteJoueur, carteAdverse);
			joueurAdverse.definirCarte(numeroCarteAdverse, carteJoueur);

		}
	}

}
