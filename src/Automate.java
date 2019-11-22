import Etats.Etat;
import Etats.EtatInitial;
import Etats.Memoire;

public class Automate {

    private Etat etatCourant = null;

    public Automate(Memoire memoire) {
            etatCourant = new EtatInitial(memoire);
    }
    //Changement l'état courant de l'automate
    public void evoluer(){
           etatCourant = etatCourant.transition();
        System.out.println(etatCourant.toString());
    }
}
