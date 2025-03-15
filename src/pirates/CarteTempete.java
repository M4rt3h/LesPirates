package pirates;

import java.util.Arrays;
import java.util.List;
import java.util.*;

public class CarteTempete extends Carte {

	public CarteTempete(String nom, String description, String rarete) {
		setDescription(description);
		setNomCarte(nom);
		setRarete(rarete);

	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + ".";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		Affichage affichage = new Affichage();
		List<Carte> CartesDesDeuxJoueurs = Arrays.asList();
		for (int i = 0; i < 5; i++) {
			CartesDesDeuxJoueurs.add(joueurCourant.getCarte(i));
			CartesDesDeuxJoueurs.add(joueurAdverse.getCarte(i));
		}
		Collections.shuffle(CartesDesDeuxJoueurs);
		affichage.afficherMessage("Une violente tempête éclate ! Les vents furieux mélangent les cartes des joueurs !");
		for (int i = 0; i < 5; i++) {
			joueurCourant.definirCarte(i, CartesDesDeuxJoueurs.get(i));
			joueurAdverse.definirCarte(i, CartesDesDeuxJoueurs.get(i + 5));
		}
	}
}
