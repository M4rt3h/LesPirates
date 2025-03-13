package pirates;

import java.util.Random;

public class Jeu {
	private Personnage joueur1;
	private Personnage joueur2;
	private static IAffichage affichage;
	private int nbCartes = 0;
	private Carte[] pioche;
	private String nomJoueur1 = "Jack le Borgne";
	private String nomJoueur2 = "Bill Jambe-de-Bois";

	public Jeu() {
		this.joueur1 = new Personnage(nomJoueur1);
		this.joueur2 = new Personnage(nomJoueur2);
		this.pioche = new Carte[60];
		this.remplirPioche();

	}

	public static IAffichage getAffichage() {
		return affichage;
	}

	public static void setAffichage(IAffichage affichage) {
		Jeu.affichage = affichage;
	}

	public void demarrerJeu() {
		affichage.afficherMessage(
				"\n╔════════════════════════════════════════════╗\n║                                            ║\n║          Début du jeu des Pirates !        ║\n║                                            ║\n╚════════════════════════════════════════════╝\n");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				joueur1.ajouterCarte(piocherCarte());
			} else {
				joueur2.ajouterCarte(piocherCarte());
			}
		}
		while (!jeuTermine()) {

			tourDeJeu(joueur1);
			if (jeuTermine()) {
				break;
			}
			tourDeJeu(joueur2);
		}

		afficherResultat();

	}

	private void afficherResultat() {
		if (joueur1.getPV() <= 0) {
			affichage.afficherMessage(nomJoueur1 + " remporte la partie !");
		} else if (joueur2.getPV() <= 0) {
			affichage.afficherMessage(nomJoueur2 + " remporte la partie !");
		} else if (joueur1.getPopularite() >= 5) {
			affichage.afficherMessage(nomJoueur1 + " devient capitaine !");
		} else if (joueur2.getPopularite() >= 5) {
			affichage.afficherMessage(nomJoueur2 + " devient capitaine !");
		}
	}

	private void remplirPioche() {
		Random random = new Random();
		TypesCarte[] typesDeCartes = TypesCarte.values();

		for (int i = 0; i < 60; i++) {
			int indexAleatoire = random.nextInt(typesDeCartes.length);
			Carte carte = typesDeCartes[indexAleatoire].getCarte();
			ajouterCarte(carte); // Ajouter la carte à la pioche
		}
	}

	public Carte piocherCarte() {
		if (nbCartes > 0) {
			return pioche[--nbCartes]; // Retourne la dernière carte de la pioche et décrémente le compteur
		} else {
			return null; // La pioche est vide
		}
	}

	public void ajouterCarte(Carte carte) {
		pioche[nbCartes++] = carte; // Ajoute la carte à la fin de la pioche et incrémente le compteur
	}

	private boolean jeuTermine() {
		return joueur1.getPV() <= 0 || joueur2.getPV() <= 0 || joueur1.getPopularite() >= 5
				|| joueur2.getPopularite() >= 5;
	}

	private void tourDeJeu(Personnage joueur) {
		affichage.afficherMessage("=================================================");
		affichage.afficherMessage("Tour de " + joueur.getNom());
		affichage.afficherMessage("=================================================");
		affichage.afficherInfosJoueur(joueur);

		joueur.ajouterCarte(piocherCarte());

		affichage.afficherMessage("Choisissez une carte parmis les suivantes :\n");
		affichage.afficherMain(joueur);

		int choix = affichage.lireReponse();
		Personnage joueurAdverse;

		if (joueur == joueur1) {
			joueurAdverse = joueur2;
		} else {
			joueurAdverse = joueur1;
		}
		joueur.utiliserCarte(choix, joueur, joueurAdverse); // Méthode à implémenter dans Personnage

	}

	// Je sais pas comment l'implémenter je verrais plus tard
	// public Personnage choisirPremierJoueur(Personnage pirateBill, Personnage
	// pirateJack) {
	// int randomNumber = (int) (Math.random() * 2);
	// if (randomNumber == 0) {
	// return pirateBill;
	// } else {
	// return pirateJack;
	// }
	// }

	public static void main(String[] args) {
		IAffichage affichage = new Affichage();
		Jeu.setAffichage(affichage);
		Jeu jeu = new Jeu();
		jeu.demarrerJeu();
	}
}