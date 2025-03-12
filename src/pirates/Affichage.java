package pirates;

public class Affichage implements IAffichage {
    
    @Override
    public void afficherMain(Personnage joueur) {
        System.out.println("Main de " + joueur.getNom() + " : " + joueur.getMain());
    }
    

    }
}
