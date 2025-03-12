package pirates;

public enum TypesCarte {
    ABORDAGE(new CarteAbordage()),
	COUPDESABRE(new CarteCoupDeSabre()),
	ATTAQUE(new CarteAttaque()),
	MAINDEFER(new CarteMainDeFer()),
	POPULARITE(new CartePopularite()),
	REGENERATION(new CarteRegeneration()),
	VOL(new CarteVol())
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