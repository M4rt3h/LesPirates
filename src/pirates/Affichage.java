package pirates;

public class Affichage implements IAffichage {
    
    @Override
    public void afficherMain(Personnage joueur) {
        System.out.println("Main de " + joueur.getNom() + " : " + joueur.getMain());
    }
    
    @Override
    public void afficherInfosJoueur(Personnage joueur) {
        System.out.println(joueur.getNom() + " - PV: " + joueur.getPV() + " - Popularité: " + joueur.getPopularite());
    }

}
