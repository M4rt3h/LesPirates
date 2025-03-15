package pirates;

public class CarteTempete extends Carte{

	
	public CarteTempete(String nom, String description, int force, String rarete) {
		setDescription(description);
		setNomCarte(nom);
		setRarete(rarete);

	}
	@Override
	public String carteToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		// TODO Auto-generated method stub
		
	}

}
