package Etats;

public class EtatPause implements Etat {
    private Memoire mem = null;
    private Gimli gimli = null;

    public EtatPause(Memoire memoire, Gimli gimli) {
        mem = memoire;
        this.gimli = gimli;
    }

    @Override
    public Etat transition() {
        action();
        Etat etat = null;
        if (mem.getAlcoolemie() < 8)
            etat = new EtatMine(this.mem,gimli);
        else
            etat = new EtatLit(this.mem,gimli);
        return etat;
    }

    @Override
    public boolean action() {
        mem.setTemps(mem.getTemps()+1);
        mem.setAlcoolemie(mem.getAlcoolemie()+0.30);
        return true;
    }
}
