package Etats;

public class EtatLit implements Etat {
    private Memoire memoire;
    private Gimli gimli;

    public EtatLit(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
    }

    @Override
    public Etat transition() {
        action();
        return new EtatMine(memoire,gimli);
    }

    @Override
    public boolean action() {
        memoire.setAlcoolemie(0);
        memoire.setTemps(memoire.getTemps()+3);
        return true;
    }
}
