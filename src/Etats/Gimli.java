package Etats;
import java.util.Random;

public class Gimli {

    private Random random;

    public Gimli() {
        random = new Random();

    }

    public boolean reussite(double proba) {
        double ran = Math.random();
        boolean res = false;
        if (ran > proba)
            res = true;
        return res;
    }
}
