package pirates;

import java.util.Scanner;

public class Affichage implements IAffichage {
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void afficherMain(Personnage joueur) {
		System.out.println(joueur.getMain());
	}

	@Override
	public void afficherInfosJoueur(Personnage joueur) {
		System.out.println(" \n- PV: " + joueur.getPV() + " \n- Popularité: " + joueur.getPopularite() + "\n");
	}

	@Override
	public void afficherMessage(String message) {
		System.out.println(message);
	}

	@Override
	public int lireReponse() {
	    while (!scanner.hasNextInt()) {
	        System.out.println("Veuillez entrer un nombre valide.");
	        scanner.next(); 
	    }
	    int reponse = scanner.nextInt(); // Lire l'entier valide
	    scanner.nextLine(); 
	    return reponse;
	}

}
