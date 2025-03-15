package pirates;

public class CarteRegeneration extends Carte {

	int regen = 0;
	private void setRegen(int regen) {
		this.regen = regen;
	}

	public CarteRegeneration(String nom, String description, int force, String rarete) {
		setDescription(description);
		setNomCarte(nom);
		setRegen(force);
		setRarete(rarete);

	}

	@Override
	public String carteToString() {
		return nomCarte + " (" + rarete + ")\n" + description + "\n" + "Tu recuperes " + String.valueOf(regen)
				+ " PV\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurCourant.modifVie(regen);

	}
}
