package it.unicam.cs.LocalDevelopmentPlatform.luoghi;
/*
Classe di comodo per rappresentare una coordinata geografica
 */
public class Coordinata {

    private double latitudine;
    private double longitudine;

    public double getLatitudine() {
        return latitudine;
    }
    public double getLongitudine() {
        return longitudine;
    }

    public Coordinata(double latitudine, double longitudine) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }
}

