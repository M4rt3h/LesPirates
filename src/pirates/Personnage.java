package pirates;

public class Personnage {
	
	private int nbPV;
	private int nbPopularite;
	private Carte[] main = new Carte[4];

	
	
	public int getPopularite() {
		return nbPopularite;
	}
	public int getPV() {
		return nbPV;	
	}
	
	public Carte getCarteJoueur(int numeroCarte) {
		return main[numeroCarte];
	}
	
//	public Carte[] donnerMain
}
