package pirates;

public class Personnage {

	private String nom;
	private int nbPV;
	private int nbPopularite;
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

	public Carte getCarteJoueur(int numeroCarte) {
		return laMain[numeroCarte];
	}

	// String retour = str1.concat(str2);

	public String donnerMain() {
	    StringBuilder laMainDuJoueur = new StringBuilder();
	    for (int i = 0; i < laMain.length; i++) {
	        if (laMain[i] != null) { //éviter les erreurs de carte nulle
	            laMainDuJoueur.append("Carte ").append(i + 1).append("\n").append(laMain[i].carteToString()).append("\n");
	        } else {
	            laMainDuJoueur.append("Carte ").append(i + 1).append("\n").append("Carte vide").append("\n");
	        }
	    }
	    return laMainDuJoueur.toString();
	}
}
