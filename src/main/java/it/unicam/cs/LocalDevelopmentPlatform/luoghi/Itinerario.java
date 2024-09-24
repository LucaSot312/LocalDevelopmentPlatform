package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;
/*
Entity class per la rappresentazione di un Itinerario
 */
@Document(collection= "Itinerario")
public class Itinerario {
    @Id
    private int id;

    private String nome;
    /*
    In questo caso un itinerario viene rappresentato come un vettore degli id dei punti di interesse che lo compongono
     */
    private ArrayList<Integer> itinerario;
    private String  descrizione;

    public Itinerario(String nome, ArrayList<Integer> itinerario, String descrizione){
        this.nome = nome;
        this.itinerario = itinerario;
        this.descrizione = descrizione;
        this.id = Math.abs(this.hashCode());
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

    public ArrayList<Integer> getItinerario() {
        return itinerario;
    }

    public void setItinerario(ArrayList<Integer> itinerario) {
        this.itinerario = itinerario;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}

