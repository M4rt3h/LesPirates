package pirates;

public class Personnage {

	Affichage affichage = new Affichage();

	private String nom;
	private int nbPV = 5;
	private int nbPopularite = 0;
	private Carte[] laMain = new Carte[4];

	public Personnage(String nom) {
		this.nom = nom;
	}

	public int getPopularite() {
		return nbPopularite;
	}

	public int getPV() {
		return nbPV;
	}

	public String getNom() {
		return nom;
	}

	public Carte getCarte(int numeroCarte) {
		return laMain[numeroCarte];
	}

	public void modifVie(int pvPerdu) {
		if (nbPV + pvPerdu <= 0) {
			nbPV = 0;
		} else {
			nbPV += pvPerdu;
		}
	}

	public void modifPopularite(int popPerdu) {
		if (nbPopularite + popPerdu <= 0) {
			nbPopularite = 0;
		} else {
			nbPopularite += popPerdu;
		}
	}

	public boolean estMort() {
		return nbPV <= 0;
	}

	public boolean estAssezPopulaire() {
		return nbPopularite >= 5;
	}

	public boolean ajouterCarte(Carte laCarte) {
		boolean estAjoute = false;
		for (int i = 0; i < laMain.length; i++) {
			if (laMain[i] == null) {
				laMain[i] = laCarte;
				estAjoute = true;
			}
		}
		return estAjoute;
	}

	public void definirCarte(int indice, Carte laCarte) {
		laMain[indice] = laCarte;
	}

	public void utiliserCarte(int indiceCarte, Personnage joueurCourant, Personnage joueurAdverse) {
		if (laMain.length == 0) {
			affichage.afficherMessage(nom + " n’a aucune carte à utiliser !");
			return;
		}

		String Nomcarte = laMain[indiceCarte].getNomCarte();
		Carte laCarte = laMain[indiceCarte];
		joueurCourant.enleverCarte(indiceCarte);
		// String carte = laMain.remove(0);
		affichage.afficherMessage(nom + " utilise la carte : " + Nomcarte);
		
		laCarte.joueurUtiliserCarte(joueurCourant, joueurAdverse);

		enleverCarte(indiceCarte);
		if (nbPV < 0)
			nbPV = 0; // Empêcher les PV négatifs
	}

	public boolean enleverCarte(int indiceCarte) {
		boolean estRetire = false;
		if (laMain[indiceCarte] != null) {
			laMain[indiceCarte] = null;
			estRetire = true;
		}
		return estRetire;

	}

	public String getMain() {
		StringBuilder laMainDuJoueur = new StringBuilder();
		for (int i = 0; i < laMain.length; i++) {
			if (laMain[i] != null) {
				laMainDuJoueur.append("Carte ").append(i + 1).append("\n").append(laMain[i].carteToString())
						.append("\n");
			} else {
				laMainDuJoueur.append("Carte ").append(i + 1).append("\n").append("Carte vide").append("\n");
			}
		}
		return laMainDuJoueur.toString();
	}
}