package pirates;

public enum TypesCarte {
   // ABORDAGE(new CarteAbordage()),
	COUPDESABRE(new CartePvEtPopularite("Coup de sabre", "Muni de ton fameux sabre, tu assenes un coup digne de ta legende a ton adversaire","Rare",-4,2)),
	ATTAQUE(new CarteAttaque("Attaque simple", "Tu jettes un cailloux sur ton adversaire...",1,"Commune")),
	MAINDEFER(new CarteMainDeFer()),
	POPULARITE(new CartePopularite()),
	REGENERATION(new CarteRegeneration()),
	VOLSIMPLE(new CarteVol("Vol", "Tu peux voler une carte de ton choix a ton adversaire\n", "Legendaire")),
	PERROQUET(new CartePerroquet()),
	COLLIER(new CarteCollier()),
	MENDIANT(new CarteMendiant()),
	KRAKEN(new CarteKraken()),
	SABAT(new CartePvEtPopularite("Coup de sabat", "Tu donnes un coup de jambes de bois à ton adversaire mais tu glisses et tombes...","Commune",-2,-3))
    ;

    private final Carte carte;

    // Constructeur de l'enum
    TypesCarte(Carte carte) {
        this.carte = carte;
    }

    // Getter pour accéder à la carte
    public Carte getCarte() {
		return carte;
	}
}