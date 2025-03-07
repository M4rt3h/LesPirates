package pirates;

public class Personnage {

	private String nom;
	private int nbPV = 5;
	private int nbPopularite = 0;
	private Carte[] laMain = new Carte[4];

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

	// public boolean setCarte() a voir si besoin de rajouter puisqu'il y a
	// ajouterCarte

	public void perdreVie(int pvPerdu) {
		if (nbPV - pvPerdu <= 0) {
			nbPV = 0;
		} else {
			nbPV -= pvPerdu;
		}
	}

	public void gagnerVie(int pvGagnes) {
		nbPV += pvGagnes;
	}

	public void gagnerPopularite(int popGagne) {
		nbPopularite += popGagne;
	}

	public void perdrePopularite(int popPerdu) {
		if (nbPopularite - popPerdu <= 0) {
			nbPopularite = 0;
		} else {
			nbPopularite -= popPerdu;
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
