package Etats;

public class EtatLit implements Etat {
    private Memoire memoire;
    private Gimli gimli;
    private static int nbInstance = 0;

    @Override
    public String toString() {
        return "EtatLit Nombre d'instance : "+nbInstance;
    }

    public EtatLit(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
        nbInstance++;
    }
    //Renvoie à un état mine
    @Override
    public Etat transition() {
        action();
        return new EtatMine(memoire,gimli);
    }
    //Remet le taux d'alcoolémie à 0
    @Override
    public boolean action() {
        memoire.setAlcoolemie(0);
        memoire.setTemps(memoire.getTemps()+3);
        return true;
    }
}
