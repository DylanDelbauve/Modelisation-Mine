package Etats;

public class EtatForgeron implements Etat {
    private Memoire memoire;
    private Gimli gimli;
    private static int nbInstance = 0;

    public EtatForgeron(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
        nbInstance++;
    }
    //Renvoie un état en fonction du taux d'alcool et de la réussite de fuite de la mine
    @Override
    public Etat transition() {
        boolean reussite = action();
        Etat etat = null;
        if (memoire.getAlcoolemie() >= 8)
            etat = new EtatLit(this.memoire, gimli);
        else if (reussite)
            etat = new EtatMine(this.memoire,gimli);
        else
            etat = new EtatCommander(this.memoire,gimli);
        return etat;
    }

    @Override
    public String toString() {
        return "EtatForgeron Nombre d'instance : "+nbInstance;
    }
    //teste si le nain arrive à fuir
    @Override
    public boolean action() {
        memoire.setTemps(memoire.getTemps()+1);
        memoire.setAlcoolemie(memoire.getAlcoolemie()-0.10);
        boolean res = false;
        if (gimli.reussite(0.33))
            res = true;
        return res;
    }
}
