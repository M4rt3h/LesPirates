package pirates;

import java.util.Random; //Pour ajouter des cartes de maniere aléatoire dans la pioche

public class Jeu {
	private int nbCartes = 0;
	private Carte[] pioche = new Carte[60]; // Ajout de la pioche

	public Jeu() {
		this.pioche = new Carte[100]; // Initialisation de la pioche avec une taille maximale
		this.remplirPioche(); // Remplir la pioche au début du jeu
	}

	private void remplirPioche() {
		Random random = new Random(); // Pour générer des indices aléatoires
		TypesCarte[] typesDeCartes = TypesCarte.values(); // Récupère toutes les valeurs de l'enum

		for (int i = 0; i < 60; i++) { //Ue pioche de 60 cartes 
			int indexAleatoire = random.nextInt(typesDeCartes.length);
			Carte carte = typesDeCartes[indexAleatoire].getCarte();
			ajouterCarte(carte); // Ajouter la carte à la pioche
		}
	}

	// int randomNumberInRange = random.nextInt((max - min) + 1) + min;

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

	public Pirate choisirPremierJoueur(Pirate pirateBill, Pirate pirateJack) {
		// Code pour déterminer aléatoirement quel pirate commence
		// ...
	}

	public void lancerJeu() {
		// Code pour initialiser et lancer le jeu
		// ...
	}
}