package pirates;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

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
		List<Carte> cartesCommune = new ArrayList<>();
		List<Carte> cartesRare = new ArrayList<>();
		List<Carte> cartesLegendaire = new ArrayList<>();
		List<Carte> cartesEpic = new ArrayList<>();

		// Séparer les cartes selon leur rareté
		for (TypesCarte type : typesDeCartes) {
			Carte carte = type.getCarte();
			switch (carte.getRarete()) {
			case "Commune":
				cartesCommune.add(carte);
				break;
			case "Rare":
				cartesRare.add(carte);
				break;
			case "Legendaire":
				cartesLegendaire.add(carte);
				break;
			case "Epic":
				cartesEpic.add(carte);
				break;
			}
		}

		for (int i = 0; i < 60; i++) {
			int tirage = random.nextInt(100); // Générer un nombre entre 0 et 99
			Carte carteSelectionnee;

			if (tirage < 50 && !cartesCommune.isEmpty()) { // 50% de chances
				carteSelectionnee = cartesCommune.get(random.nextInt(cartesCommune.size()));
			} else if (tirage < 80 && !cartesRare.isEmpty()) { // 30% de chances
				carteSelectionnee = cartesRare.get(random.nextInt(cartesRare.size()));
			} else if (tirage < 95 && !cartesEpic.isEmpty()) { // 15% de chances
				carteSelectionnee = cartesEpic.get(random.nextInt(cartesEpic.size()));
			} else if (!cartesLegendaire.isEmpty()) { // 5% de chances
				carteSelectionnee = cartesLegendaire.get(random.nextInt(cartesLegendaire.size()));
			} else { // Sécurité si une liste est vide
				carteSelectionnee = typesDeCartes[random.nextInt(typesDeCartes.length)].getCarte();
			}

			ajouterCarte(carteSelectionnee); // Ajouter la carte à la pioche
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