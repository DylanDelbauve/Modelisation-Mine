package Etats;

public class EtatMine implements Etat {
    private Memoire memoire = null;
    private Gimli gimli = null;
    private static int nbInstance;

    private static final double PROBACASSE = 0.15;

    @Override
    public String toString() {
        return "EtatMine Nombre d'instance : "+nbInstance;
    }

    public EtatMine(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
        nbInstance++;
    }
    /* Change d'état en fonction de son alcoolémie et de sa réussite à miner sans casser sa pioche */
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

    /* Retourne vrai si le nain mine sans casser sa pioche */
    public boolean action() {
        double proba = PROBACASSE + 0.8 * Math.round(memoire.getAlcoolemie());
        memoire.setTemps(memoire.getTemps()+1);
        memoire.setAlcoolemie(memoire.getAlcoolemie()-0.15);
        return gimli.reussite(proba);
    }
}
