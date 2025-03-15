package pirates;

public enum TypesCarte {
    //ABORDAGE(new CarteAttaque("Abordage","Ton equipage et toi abordez le navire adverse",-2,"Commune")),
	//COUPDESABRE(new CartePvEtPopularite("Coup de sabre", "Muni de ton fameux sabre, tu assenes un coup digne de ta legende a ton adversaire","Rare",-4,2)),
	//ATTAQUE(new CarteAttaque("Attaque simple", "Tu jettes un cailloux sur ton adversaire...",1,"Commune")),
	//MAINDEFER(new CartePopularite("Main de fer","Tu tapes du poing sur la table et remets ton equipage dans le rang",-1,"Commune",true)),
	//POPULARITE(new CartePopularite("Gain de popularite","Tu fais un bisou à ton second",1,"Commune",true)),
	//REGENERATION(new CarteRegeneration("Regeneration","Tu bois du rhum dans le crane de l'ancien capitaine",1,"Commune")),
	//VOLSIMPLE(new CarteVol("Vol", "Tu peux voler une carte de ton choix a ton adversaire\n", "Legendaire")),
	//PERROQUET(new CartePopularite("Perroquet","Ton perroquet lance une pique mordante à l’infortuné marin du navire",1,"Commune",true)),
	//COLLIER(new CartePopularite("Mettre un collier","Tu habilles ton costume de ton plus beau collier...",-2,"Commune",true)),
	//MENDIANT(new CartePopularite("Mendiant", "Tu jettes une pièce à ton adversaire",-3,"Rare",false)),
	//KRAKEN1(new CarteKraken("Kraken des profondeurs","Le Kraken apparait et te propose un deal","Epic",1)),
	//KRAKEN2(new CarteKraken("Kraken des abysses","Ce Kraken peut te faire gagner, ou te tuer","Legendaire",2)),
	KRAKEN3(new CarteKraken("Kraken joueur","Tu as une petite chance de t'en sortir","Rare",3))
	//SABAT(new CartePvEtPopularite("Coup de sabat", "Tu donnes un coup de jambes de bois à ton adversaire mais tu glisses et tombes...","Commune",-2,-3))
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