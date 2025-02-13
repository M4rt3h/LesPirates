package pirates;
import java.util.Scanner;

public class Affichage {
	
	public String afficherAcceuil() {
		return "Bienvenue sur le jeu\n";
	}
	
	public String demanderNomJoueur(int numJoueur) {
		return "Quel est le nom du joueur " + String.valueOf(numJoueur) + " ?\n";
	}
	
	public String afficherCarte() {
		return "Carte Attaque\nCoup Bas\nforce = 7";
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Affichage affichage = new Affichage();
		System.out.println(affichage.afficherAcceuil());
		System.out.println(affichage.demanderNomJoueur(1));
        String nomJoueur1 = scanner.nextLine(); // Lecture de l'entr�e utilisateur
        System.out.println("Le joueur 1 s'appelle : " + nomJoueur1 + "\n");
		System.out.println(affichage.demanderNomJoueur(2));
        String nomJoueur2 = scanner.nextLine(); // Lecture de l'entr�e utilisateur
        System.out.println("Le joueur 2 s'appelle : " + nomJoueur2 + "\n");
        System.out.println(affichage.afficherCarte());
        
		

	}

}
