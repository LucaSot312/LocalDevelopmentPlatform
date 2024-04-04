package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import java.util.Vector;

public class Itinerario {
    private Vector<PuntoDiInteresse> itinerario;
    private String  descrizione;

    public Itinerario(Vector<PuntoDiInteresse> itinerario, String descrizione) {
        this.itinerario = itinerario;
        this.descrizione = descrizione;
    }
}

