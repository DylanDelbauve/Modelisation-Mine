package Etats;

public class Memoire {
    private double alcoolemie = 0;
    private int temps = 0;

    public double getAlcoolemie() {
        return alcoolemie;
    }

    public void setAlcoolemie(double alcoolemie) {
        this.alcoolemie = alcoolemie;
        if(this.alcoolemie < 0)
            this.alcoolemie = 0;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
}
