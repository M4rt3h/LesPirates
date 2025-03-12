package pirates;

public class CarteKraken extends Carte {

	private int populariteDeCarte = -2;

	public CarteKraken() {
		setNomCarte("Carte Kraken");
		setDescription("Le Kraken apparait et te propose un deal");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "l'adversaire perd " + String.valueOf(-populariteDeCarte)
				+ " de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		Affichage affichage = new Affichage();
		affichage.afficherMessage("Kraken : Jouons à pile ou face, si tu gagnes je coulerai le navire de "
				+ joueurAdverse.getNom() + " sinon tu coules");

		affichage.afficherMessage("Faisons simple, choisi 1 pour pile et 0 pour face.");
		int choixKraken = (int) (Math.random() * 2); // 0 pour face, 1 pour pile
		// Partie du code qui choisi aléatoirement entre 0 et 1
		int reponse = affichage.lireReponse();
		System.out.println(reponse); // Probleme que je comprend pas : quand je met 0 ca retourne 1 mais quand je met
										// ca retourne 0. Donc j'ai inverser les if et else pour que ca marche
		System.out.println(choixKraken);
		if (reponse == choixKraken) {
			affichage.afficherMessage("Kraken : Tu n'aurais pas du tenter ta chance...");
			joueurAdverse.modifVie(-joueurAdverse.getPV());
		} else {
			affichage.afficherMessage("Kraken : Je n'ai qu'une seule parole.");
			joueurCourant.modifVie(-joueurCourant.getPV());
		}

	}

}
