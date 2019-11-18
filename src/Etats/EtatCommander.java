package Etats;

public class EtatCommander implements Etat {
    private Memoire memoire;
    private Gimli gimli;

    public EtatCommander(Memoire memoire, Gimli gimli) {
        this.memoire = memoire;
        this.gimli = gimli;
    }
    // Renvoie l'état suivant en fonction du taux d'alcoolémie et si Gimli s'est battu avec le Tavernier
    @Override
    public Etat transition() {
        boolean battre = action();
        Etat etat = null;
        if (memoire.getAlcoolemie() >= 8)
            etat = new EtatLit(memoire,gimli);
        else if (!battre)
            etat = new EtatMine(memoire,gimli);
        else
            etat = new EtatCommander(memoire,gimli);
        return etat;
    }

    @Override
    public boolean action() {
        boolean battre = false;
        boolean res = false;
        double proba = 0.05 + 0.15 * Math.round(memoire.getAlcoolemie());
        battre = gimli.reussite(proba);
        if (!battre) {
            res = false;
            memoire.setAlcoolemie(memoire.getAlcoolemie()-0.10);
        }
        else {
            memoire.setTemps(memoire.getTemps()+1);
            memoire.setAlcoolemie(memoire.getAlcoolemie()+1.1);
            res = true;
        }
        return res;
    }
}
