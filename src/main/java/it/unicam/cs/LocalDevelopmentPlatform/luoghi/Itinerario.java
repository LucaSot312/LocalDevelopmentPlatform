package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Vector;

@Document(collection= "Itinerario")
public class Itinerario {
    @Id
    private int id;

    private String nome;
    private Vector<Integer> itinerario;
    private String  descrizione;

    public Itinerario(String nome, Vector<Integer> itinerario, String descrizione){
        this.nome = nome;
        this.id = this.hashCode();
        this.itinerario = itinerario;
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itinerario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vector<Integer> getItinerario() {
        return itinerario;
    }

    public void setItinerario(Vector<Integer> itinerario) {
        this.itinerario = itinerario;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}

