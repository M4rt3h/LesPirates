package pirates;

public class Jeu {
	private int nbCartes = 0;
	private Carte[] pioche; // Ajout de la pioche

	public Jeu() {
		this.pioche = new Carte[100]; // Initialisation de la pioche avec une taille maximale
		this.remplirPioche(); // Remplir la pioche au début du jeu
	}

	private void remplirPioche() {
		// Code pour créer et ajouter toutes les cartes possibles à la pioche
		// ...
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

	public Pirate choisirPremierJoueur(Pirate pirateBill, Pirate pirateJack) {
		// Code pour déterminer aléatoirement quel pirate commence
		// ...
	}

	public void lancerJeu() {
		// Code pour initialiser et lancer le jeu
		// ...
	}
}