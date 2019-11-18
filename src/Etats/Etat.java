package Etats;

import Etats.Memoire;

public interface Etat {

    public abstract Etat transition();

    public abstract boolean action();
}
