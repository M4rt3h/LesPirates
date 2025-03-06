package pirates;

public class Jeu {
	private int nbCartes = 0;
	private Carte[] pioche; // Ajout de la pioche

	public Jeu() {
		this.pioche = new Carte[100]; // Initialisation de la pioche avec une taille maximale
		this.remplirPioche(); // Remplir la pioche au d�but du jeu
	}

	private void remplirPioche() {
		// Code pour cr�er et ajouter toutes les cartes possibles � la pioche
		// ...
	}

	public Carte piocherCarte() {
		if (nbCartes > 0) {
			return pioche[--nbCartes]; // Retourne la derni�re carte de la pioche et d�cr�mente le compteur
		} else {
			return null; // La pioche est vide
		}
	}

	public void ajouterCarte(Carte carte) {
		pioche[nbCartes++] = carte; // Ajoute la carte � la fin de la pioche et incr�mente le compteur
	}

	public Pirate choisirPremierJoueur(Pirate pirateBill, Pirate pirateJack) {
		// Code pour d�terminer al�atoirement quel pirate commence
		// ...
	}

	public void lancerJeu() {
		// Code pour initialiser et lancer le jeu
		// ...
	}
}