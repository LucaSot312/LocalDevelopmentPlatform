package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import java.util.Objects;
import java.util.Vector;

public class Itinerario {

    private int ID;
    private Vector<PuntoDiInteresse> itinerario;
    private String  descrizione;

    public Itinerario(Vector<PuntoDiInteresse> itinerario, String descrizione){
        this.ID= this.hashCode();
        this.itinerario = itinerario;
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itinerario);
    }
}

