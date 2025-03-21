package pirates;

public class CarteAttaque extends Carte {

	protected int pointAttaque;

	public CarteAttaque(String nom, String description, int force, String rarete) {
		setNomCarte(nom);
		setDescription(description);
		setPointAttaqueCarte(force);
		setRarete(rarete);
	}

	protected void setPointAttaqueCarte(int ptAttaque) {
		pointAttaque = ptAttaque;
	}

	protected int getPointAttaqueCarte() {
		return pointAttaque;
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + "\n" + "L'adversaire perd "
				+ String.valueOf(getPointAttaqueCarte()) + " PV\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(-getPointAttaqueCarte());
	}
}
