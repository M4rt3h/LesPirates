package pirates;

import java.util.Arrays;
import java.util.List;

public class CarteKraken extends Carte {

	int modeDeJeu = 0;

	public CarteKraken(String nom, String description, String rarete, int leModeDeJeu) {
		setNomCarte(nom);
		setDescription(description);
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
		if (modeDeJeu == 1) {
			affichage.afficherMessage("Kraken : Jouons à pile ou face, si tu gagnes je coulerai le navire de "
					+ joueurAdverse.getNom() + " sinon tu coules");

			affichage.afficherMessage("         Faisons simple, choisi 1 pour pile et 0 pour face.");
			choixKraken = (int) (Math.random() * 2); // 0 pour face, 1 pour pile
			// Partie du code qui choisi aléatoirement entre 0 et 1
			while ((reponse != 0) && (reponse != 1) && (tentative > 0)) {
				reponse = affichage.lireReponse() + 1;

				if (reponse == choixKraken) {
					affichage.afficherMessage("Kraken : Tu n'aurais pas du tenter ta chance...");
					joueurAdverse.modifVie(-joueurAdverse.getPV());
				} else if ((reponse != 0) && (reponse != 1)) {
					tentative -= 1;
					if (tentative <= 0) {
						break; // Pour ne pas afficher qu'il reste '0' chance
					}
					affichage.afficherMessage("Kraken : Ne te moque pas de moi");
					affichage.afficherMessage("         encore un coup foireux comme celui là et tu es mort");

				} else {
					affichage.afficherMessage("Kraken : Je n'ai qu'une seule parole.");
					joueurCourant.modifVie(-joueurCourant.getPV());
				}
			}
			if (tentative <= 0) {
				affichage.afficherMessage("Kraken : Tu l'auras voulu");
				affichage.afficherMessage("*Le Kraken entraine ton navire dans les profondeurs*");
				joueurAdverse.modifVie(-joueurAdverse.getPV()); // Je n'ai pas trouvé pourquoi je dois mettre
																// joueurAdverse au lieu de joueurCourant ici
			}

		} else if (modeDeJeu == 2) {
			List<Integer> reponsesPossibles = Arrays.asList(1, 2, 3);
			affichage.afficherMessage("Kraken : Je vois que le jeune pirate que tu es a plein de bravoure");
			affichage.afficherMessage("         C'est pourquoi je vais te proposer un deal que tu ne pourras refuser");
			affichage.afficherMessage("         Nous allons jouer à pierre feuille ciseaux.");
			affichage.afficherMessage("Saisi 1 pour la pierre, 2 pour la feuille et 3 pour les ciseaux");
			choixKraken = (int) (Math.random() * 3);
			while (!reponsesPossibles.contains(reponse) && (tentative > 0)) {
				reponse = affichage.lireReponse() + 1;

				if (choixKraken == reponse) {
					affichage.afficherMessage(
							"Kraken : Je vois que nous sommes sur une egalite,\n         je vais te faire une faveur et retirer 1 PV a ton adversaire et nous serons quitte.");
					joueurAdverse.modifVie(-1);
				} else if ((choixKraken == 1) && (reponse == 3)) {
					// Le kraken gagne
					affichage.afficherMessage(
							"Kraken : Tu as choisi les ciseaux...\n         ...contre la pierre...\n         MEURS !!");
					affichage.afficherMessage(
							"*Le Kraken provoque une tempête qui entoure ton navire et le fait sombrer*");
					joueurCourant.modifVie(-joueurCourant.getPV());

				} else if ((choixKraken == 3) && (reponse == 1)) {
					// joueur gagne
					affichage.afficherMessage(
							"Kraken : Force est de constaté que tu es plus fort que moi a ce jeu.\n         Je te ferais donc grand vainceur de ta bataille avec "
									+ joueurAdverse.getNom() + ".");
					joueurAdverse.modifVie(-joueurAdverse.getPV());

				} else {
					tentative -= 1;
					if (tentative <= 0) {
						break; // Pour ne pas afficher qu'il reste '0' chance
					}
					affichage.afficherMessage("Kraken : J'ai l'impression que tu sous estime notre jeu");
					affichage.afficherMessage("         refais moi encore une mauvaise blague et tu verras");
				}
			}
			if (tentative <= 0) {
				affichage.afficherMessage("Kraken : Tu ne me laisse plus le choix");
				affichage.afficherMessage("*Le Kraken souleve un ras de marre et englouti ton navire*");
				joueurAdverse.modifVie(-joueurAdverse.getPV()); // Je n'ai pas trouvé pourquoi je dois mettre
																// joueurAdverse au lieu de joueurCourant ici
			}
		} else if (modeDeJeu == 3) {
			// Mode de jeu 3 : Deviner un nombre
			int nombreSecret = (int) (Math.random() * 15);
			System.out.println(nombreSecret);
			int essaisRestants = 2;
			affichage.afficherMessage("Kraken : Cette fois, tu dois prouver ta chance...");
			affichage.afficherMessage("         Devine un nombre entre 1 et 10. Tu as " + essaisRestants
					+ " tentatives.\n         Si tu réussis, je réduirai de moitié la vie et la popularité de ton adversaire.\n         Mais si tu échoues, tu subiras le même sort.");
			while (essaisRestants > 0) {
				reponse = affichage.lireReponse() + 1;

				if (reponse == nombreSecret) {
					affichage.afficherMessage(
							"Kraken : Incroyable... Tu as de la chance, mais je tiens toujours parole.");
					joueurAdverse.modifVie(-joueurAdverse.getPV() / 2);
					joueurAdverse.modifPopularite(-joueurAdverse.getPopularite() / 2);
					affichage.afficherMessage(
							"*Le Kraken réduit la vie et la popularite de " + joueurAdverse.getNom() + "*");
					return;
				} else {
					essaisRestants--;
					if (essaisRestants > 0) {
						affichage.afficherMessage(
								"Kraken : Mauvaise réponse ! Il te reste " + essaisRestants + " essais.");
					} else {
						affichage.afficherMessage("Kraken : Ton manque de chance te condamne...");
						joueurCourant.modifVie(-joueurCourant.getPV() / 2);
						joueurCourant.modifPopularite(-joueurCourant.getPopularite() / 2);
						affichage.afficherMessage(
								"*Le Kraken réduit la vie et la popularite de " + joueurCourant.getNom() + "*");
					}
				}
			}
		}

	}
}
