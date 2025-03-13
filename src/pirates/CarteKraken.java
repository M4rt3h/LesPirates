package pirates;

public class CarteKraken extends Carte {

	public CarteKraken() {
		setNomCarte("Carte Kraken");
		setDescription("Le Kraken apparait et te propose un deal");
		setRarete("Legendaire"); // N'est pas rare

		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + "\n";
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

		if (reponse == choixKraken) {
			affichage.afficherMessage("Kraken : Tu n'aurais pas du tenter ta chance...");
			joueurAdverse.modifVie(-joueurAdverse.getPV());
		} else {
			affichage.afficherMessage("Kraken : Je n'ai qu'une seule parole.");
			joueurCourant.modifVie(-joueurCourant.getPV());
		}

	}

}
