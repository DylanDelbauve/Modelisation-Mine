package Etats;

public class EtatMine implements Etat {
    private Memoire memoire = null;
    private Gimli gimli = null;
    public EtatMine(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
    }

    @Override
    public Etat transition() {
        boolean reussite = action();
        Etat etat = null;
        if (memoire.getAlcoolemie() >= 8)
            etat = new EtatLit(this.memoire,gimli);
        else if (reussite)
            etat = new EtatPause(this.memoire,gimli);
        else
            etat = new EtatForgeron(this.memoire,gimli);
        return etat;
    }

    public boolean action() {
        double proba = 0.15 + 0.8 * Math.round(memoire.getAlcoolemie());
        memoire.setTemps(memoire.getTemps()+1);
        memoire.setAlcoolemie(memoire.getAlcoolemie()-0.15);
        return gimli.reussite(proba);
    }
}
