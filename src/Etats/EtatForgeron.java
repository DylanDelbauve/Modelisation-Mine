package Etats;

public class EtatForgeron implements Etat {
    private Memoire memoire;
    private Gimli gimli;

    public EtatForgeron(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
    }

    @Override
    public Etat transition() {
        action();
        Etat etat = null;
        if (memoire.getAlcoolemie() >= 8)
            etat = new EtatLit(this.memoire, gimli);
        else if (gimli.reussite(0.33))
            etat = new EtatMine(this.memoire,gimli);
        else
            etat = new EtatCommander(this.memoire,gimli);
        return etat;
    }

    @Override
    public boolean action() {
        memoire.setTemps(memoire.getTemps()+1);
        memoire.setAlcoolemie(memoire.getAlcoolemie()-0.10);
        return true;
    }
}
