package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Vector;

@Document(collection= "Itinerario")
public class Itinerario {
    @Id
    private int id;

    private Vector<PuntoDiInteresse> itinerario;
    private String  descrizione;

    public Itinerario(Vector<PuntoDiInteresse> itinerario, String descrizione){
        this.id = this.hashCode();
        this.itinerario = itinerario;
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itinerario);
    }
}

