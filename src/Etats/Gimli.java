package Etats;
import java.util.Random;

public class Gimli {

    private Random random;

    public Gimli() {
        random = new Random();

    }
    /* donne la réussite d'une action en fonction de la probabilité passée en paramètre */
    public boolean reussite(double proba) {
        double ran = Math.random();
        boolean res = false;
        if (ran > proba)
            res = true;
        return res;
    }
}
