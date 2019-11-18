import Etats.Memoire;

public class Main {
    public static void main(String[] args) {
        Memoire memoire = new Memoire();
        Automate nain = new Automate(memoire);
        for (int i = 0; i < 100000; i++) {
            nain.evoluer();
            System.out.println("Alcool : "+memoire.getAlcoolemie()+"\nTemps : "+memoire.getTemps());
        }
    }
}