package pirates;

public class CartePopularite extends Carte{
	private int valeurCarte;
	
	public int getValeurPop() { //recupere la valeur de la popularite
		return valeurCarte;
	}

	@Override
	public String decrireCarte() {
		return "C'est une carte de popularite";
	}
	
	@Override
	public String carteToString() {
		String affichageCarte = getNomCarte() + "\n" + "Valeur popularite = " + String.valueOf(getValeurPop()) +"\n";
		return affichageCarte;
	}
}
