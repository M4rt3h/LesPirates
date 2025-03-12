package pirates;

import java.util.Random;

public class Jeu {
	private Personnage joueur1;
	private Personnage joueur2;
	private int nbCartes = 60;
	private Carte[] pioche;;

	public Jeu() {
		this.pioche = new Carte[60];
		this.remplirPioche();
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

	private boolean jeuTerminé() {
		return joueur1.getPV() <= 0 || joueur2.getPV() <= 0 || joueur1.getPopularite() >= 5
				|| joueur2.getPopularite() >= 5;
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

	public void lancerJeu() {
		// Code pour initialiser et lancer le jeu
		// ...
	}
}