package pirates;

public class CarteAbordage extends CarteAttaque {

	public CarteAbordage() {
		setNomCarte("Carte abordage");
		setDescription("Ton equipage et toi abordez le navire adverse");
		setPointAttaqueCarte(-2);
		setRarete("Commune");
		carteToString();
	}
}