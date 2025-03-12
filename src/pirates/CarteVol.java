package pirates;

public class CarteVol extends Carte {

	public CarteVol() {
		setNomCarte("Voler une carte");
		setDescription("Tu peux voler une carte de ton adversaire mais attention ..." + "\n...au hasard");
		carteToString();
	}

	@Override
	public String carteToString() {
		return nomCarte + "\n" + description;
	}
	
	@Override
	public void joueurUtiliserCarte(Personnage joueurCourant, Personnage joueurAdverse) {
		Affichage affichage = new Affichage();
		affichage.afficherMessage("Voici la main du joueur adverse :");
		affichage.afficherMain(joueurAdverse);
		affichage.afficherMessage("Entrez le numero de la carte que vous voulez récupérer dans la main adverse :");
		//blabla scanner
		
		
		
		
		
		joueurCourant.modifPopularite(populariteDeCarte);
		joueurAdverse.modifVie(nbDegats);
	}

}
