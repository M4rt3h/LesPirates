package pirates;
import java.util.Scanner;


//Utiliser le prototype pour faire diagramme s�quence -> lorsque il y a un truc en dur (style les cartes ou les noms de joueurs)
//Il faut mettre sur le diag qu'on fait un appel le diag seq (voir photo 20/02/2025 ~12h)


public class AffichagePrototype {
	Scanner scanner = new Scanner(System.in);

	public String afficherAcceuil() {
		return "Bienvenue sur le jeu\n";
	}

	public String demanderNomJoueur(int numJoueur) {
		System.out.println("Quel est le nom du joueur " + String.valueOf(numJoueur) + " ?\n");
		String nomJoueur = scanner.nextLine();
		return nomJoueur;
	}
	
	public void lancerJeu() {
		// initialiser la partie
		int[] lePersonnage;
	}
	
	public int debuterTour(String nomJoueur, String[] main) {
		System.out.println("C'est au tour de " + nomJoueur + " de jouer !");
		System.out.println("Voici ta main :");
		for (int k=0; k<5; k++) {
			System.out.println("Carte n�"+(k+1)+" : "+main[k]+"\n");
		}
		System.out.println("Qu'est ce que tu choisis de faire ? \n(Renseigne le numero de la carte � utiliser)");
		boolean valide = false;
		int choix = -1;
		while (!valide) {
			// V�rifier si l'entr�e est un entier
			if (scanner.hasNextInt()) {
				choix = scanner.nextInt();

				// V�rifier si l'entier est entre 1 et 5
				if (choix >= 1 && choix <= 5) {
					valide = true; // Si c'est valide, sortir de la boucle
				} else {
					System.out.println("Ce n'est pas un nombre entre 1 et 5. Essayez encore.");
				}
			} else {
				// Si l'entr�e n'est pas un entier
				System.out.println("Ce n'est pas un entier valide. Essayez encore.");
				scanner.next(); // Consommer l'entr�e invalide
			}
		}
		return choix-1;
	}

	public static void main(String[] args) {
		
		//AffichagePrototype.lancerJeu(); // initialisation du jeu
		String[] joueurs = new String[2]; // Pour stocker les nom de joueurs
		Scanner scanner = new Scanner(System.in);

		AffichagePrototype affichage = new AffichagePrototype();
		affichage.afficherAcceuil();
		joueurs[0] = affichage.demanderNomJoueur(1);
		joueurs[1] = affichage.demanderNomJoueur(2);

		String[] laMain1 = new String[5]; // Pour stocker les cartes du joueur 1
		String[] laMain2 = new String[5]; // Pour stocker les cartes du joueur 2

		for (int k = 0; k < 5; k++) { // ajout des cartes aux mains de chaque joueurs
			laMain1[k] = "carteJ1 " + (k+1);
			laMain2[k] = "carteJ2 " + (k+1);
		}

		//boolean joueurPerdu = false;
		//int PV_J1 = 5; // PointsVie du joueur 1
		//int PP_J1 = 0; // PointsPopularite joueur 1
		//int PV_J2 = 5; // PointsVie du joueur 2
		//int PP_J2 = 0; // PointsPopularite joueur 2
		//int indiceJoueur = 0; // %2 pour connaitre qui joue
		//int choix = affichage.debuterTour(joueurs[0], laMain1);
		
		int choix = affichage.debuterTour(joueurs[0], laMain1);

		// changer de joueur

		scanner.close(); // fermer le scanner
	}

}
