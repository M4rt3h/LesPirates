package pirates;

public class CarteAttaque extends Carte{
	private int nbDegats;

	protected void setDegats(int degats) {
		nbDegats = degats;
	}
	
	public CarteAttaque() {
		setNomCarte("Carte attaque simple");
	}

	
	@Override
	public String carteToString() {
		return nomCarte +"\n"+ description + "\n" + "Valeur attaque = " + String.valueOf(nbDegats) +"\n";
	}
}
