package pirates;

import java.util.Scanner;

import java.util.Random;

public class Jeu {
	private Personnage joueur1;
	private Personnage joueur2;
	private Affichage affichage;
	private int nbCartes = 60;
	private Carte[] pioche;;
	private Scanner scanner;

	public Jeu() {
		this.joueur1 = new Personnage("Jack le Borgne");
		this.joueur2 = new Personnage("Bill Jambe-de-Bois");
		this.affichage = new Affichage();
		this.pioche = new Carte[60];
		this.remplirPioche();

	}

	public void demarrerJeu() {
        affichage.afficherMessage("Début du jeu des Pirates !");
        
        while (!jeuTermine()) {

        
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
		affichage.afficherMessage("\nTour de " + joueur.getNom());
		affichage.afficherInfosJoueur(joueur);

		joueur.ajouterCarte(piocherCarte());

		affichage.afficherMessage("Choisissez une carte parmis les suivantes :");
		affichage.afficherMain(joueur);
		
		int choix = scanner.nextInt();

		if (choix == 1) {
			joueur.utiliserCarte(); // Méthode à implémenter dans Personnage
		}
		
	}

	public Personnage choisirPremierJoueur(Personnage pirateBill, Personnage pirateJack) {
		Random random = new Random();
		int randomNumber = random.nextInt(2);
		if (randomNumber == 0) {
			return pirateBill;
		} else {
			return pirateJack;
		}
	}
}