package Etats;


public class EtatInitial implements Etat {

    private Memoire memoire;
    private Gimli gimli = new Gimli();

    public EtatInitial(Memoire memoire) {
        this.memoire = memoire;
    }

    @Override
    public Etat transition() {
        action();
        return new EtatMine(memoire,gimli);
    }

    @Override
    public boolean action() {
        return true;
    }
}
