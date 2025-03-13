package pirates;

public class CarteRegeneration extends Carte {

	int regen = 3;

	public CarteRegeneration() {
		setDescription("Tu bois du rhum dans le crane de l'ancien capitaine");
		setNomCarte("Regeneration de vie");
		setRarete("Rare");

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
