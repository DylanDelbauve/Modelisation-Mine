package Etats;

public class EtatPause implements Etat {
    private Memoire memoire = null;
    private Gimli gimli = null;
    private static int nbInstance = 0;

    @Override
    public String toString() {
        return "EtatPause Nombre d'instance : "+nbInstance;
    }

    public EtatPause(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
        nbInstance++;
    }

    //Renvoie un état en fonction du taux d'alcool
    @Override
    public Etat transition() {
        action();
        Etat etat = null;
        if (memoire.getAlcoolemie() < 8)
            etat = new EtatMine(this.memoire,gimli);
        else
            etat = new EtatLit(this.memoire,gimli);
        return etat;
    }
    @Override
    public boolean action() {
        memoire.setTemps(memoire.getTemps()+1);
        memoire.setAlcoolemie(memoire.getAlcoolemie()+0.30);
        return true;
    }
}
