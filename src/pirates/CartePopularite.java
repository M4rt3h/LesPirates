package pirates;

public class CartePopularite extends Carte {
	private int populariteDeCarte;


	protected void setPop(int pop) {
		populariteDeCarte = pop;
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "La carte fait gagner/perdre "+String.valueOf(populariteDeCarte) +" popularite = " + "\n";
	}
}
