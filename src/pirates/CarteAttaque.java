package pirates;

public class CarteAttaque extends Carte {

	public CarteAttaque(String nom, String description,int force, String rarete) {
		setNomCarte(nom);
		setDescription(description);
		setPointAttaqueCarte(-force);
		setRarete(rarete);
	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + "\n" + "L'adversaire perd " + String.valueOf(-getPointAttaqueCarte())
				+ " PV\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(getPointAttaqueCarte());
	}
}
