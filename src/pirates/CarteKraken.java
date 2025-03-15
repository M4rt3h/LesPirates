package pirates;

import java.util.Arrays;
import java.util.List;

public class CarteKraken extends Carte {

	int modeDeJeu = 0;

	public CarteKraken(String nom, String description, String rarete, int leModeDeJeu) {
		setNomCarte("Carte Kraken");
		setDescription("Le Kraken apparait et te propose un deal");
		setRarete(rarete);
		setModeDeJeu(leModeDeJeu);
		carteToString();
	}

	private void setModeDeJeu(int mode) {
		modeDeJeu = mode;
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + "\n";
	}

	// On va faire 3 mode de jeu : mode 0 le classique, mode 1 un peu plus dur et
	// mode 2 super dur

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		Affichage affichage = new Affichage();
		int reponse = -1;
		int choixKraken = 0;
		int tentative = 2;
		if (modeDeJeu == 0) {
			affichage.afficherMessage("Kraken : Jouons à pile ou face, si tu gagnes je coulerai le navire de "
					+ joueurAdverse.getNom() + " sinon tu coules");

			affichage.afficherMessage("         Faisons simple, choisi 1 pour pile et 0 pour face.");
			choixKraken = (int) (Math.random() * 2); // 0 pour face, 1 pour pile
			// Partie du code qui choisi aléatoirement entre 0 et 1
			while ((reponse != 0) && (reponse != 1) && (tentative > 0)) {
				reponse = affichage.lireReponse() + 1;
				System.out.println(reponse);

				if (reponse == choixKraken) {
					affichage.afficherMessage("Kraken : Tu n'aurais pas du tenter ta chance...");
					joueurAdverse.modifVie(-joueurAdverse.getPV());
				} else if ((reponse != 0) && (reponse != 1)) {
					tentative -= 1;
					if (tentative <= 0) {
						break; // Pour ne pas afficher qu'il reste '0' chance
					}
					affichage.afficherMessage("Kraken : Ne te moque pas de moi");
					affichage.afficherMessage("         encore " + String.valueOf(tentative)
							+ " coup foireux comme celui là et tu es mort");

				} else {
					affichage.afficherMessage("Kraken : Je n'ai qu'une seule parole.");
					joueurCourant.modifVie(-joueurCourant.getPV());
				}
			}
			if (tentative <= 0) {
				affichage.afficherMessage("Kraken : Tu l'auras voulu");
				affichage.afficherMessage("*Le Kraken entraine ton bateau dans les profondeurs*");
				joueurCourant.modifVie(-joueurCourant.getPV());
			}

		} else if (modeDeJeu == 1) {
			List<Integer> reponsesPossibles = Arrays.asList(1, 2, 3);
			affichage.afficherMessage("Kraken : Je vois que le jeune pirate que tu es a plein de bravoure");
			affichage.afficherMessage("         C'est pourquoi je vais te proposer un deal que tu ne pourras refuser");
			affichage.afficherMessage("         Nous allons jouer à pierre feuille ciseaux.");
			affichage.afficherMessage("Saisi 1 pour la pierre, 2 pour la feuille et 3 pour les ciseaux");
			reponse = affichage.lireReponse();
			choixKraken = (int) (Math.random() * 3);
			while (!reponsesPossibles.contains(reponse)) {
				if (choixKraken == reponse) {
					affichage.afficherMessage(
							"Kraken : Je vois que nous sommes sur une egalite,\n         je vais te faire une faveur et retirer 1 PV a ton adversaire et nous serons quitte.");
					joueurAdverse.modifVie(-1);
				} else if ((choixKraken == 1) && (reponse == 3)) {
					// Le kraken gagne

				} else if ((choixKraken == 3) && (reponse == 1)) {
					// joueur gagne
				} else {
					tentative -= 1;
					if (tentative <= 0) {
						break; // Pour ne pas afficher qu'il reste '0' chance
					}
					affichage.afficherMessage("Kraken : J'ai l'impression que tu sous estime notre jeu");
					affichage.afficherMessage("         refais moi encore " + String.valueOf(tentative)
							+ " mauvaise blague et tu verras");
				}
			}
		}
	}

}
