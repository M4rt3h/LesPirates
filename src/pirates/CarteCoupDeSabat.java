package pirates;

public class CarteCoupDeSabat extends Carte {
	protected int nbDegats = -3;
	protected int nbPop = -2;

	public CarteCoupDeSabat() {
		setNomCarte("Carte coup de sabat");
		setDescription("Tu donnes un coup de jambes de bois à ton adversaire mais tu glisses et tombe...");

	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description + "\n" + "L'adversaire perd " + String.valueOf(-nbDegats)
				+ " PV\nTu perds " + String.valueOf(-nbPop) + "de popularite\n";
	}

	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		joueurAdverse.modifVie(nbDegats);
		joueurCourant.modifPopularite(nbPop);
	}
}
