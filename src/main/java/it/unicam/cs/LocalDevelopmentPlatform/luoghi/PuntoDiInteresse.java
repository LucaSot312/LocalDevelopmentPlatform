package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import jakarta.persistence.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "PuntoDiInteresse")
public class PuntoDiInteresse {
    @Id
    private int  _id;

    private State stato;

    // Costruttore di default necessario per deserializzazione JSON
    public PuntoDiInteresse() {
    }

    // Costruttore custom
    public PuntoDiInteresse(PuntoDiInteresse punto) {
        this.stato = new NonVerificato(punto.getStato().coordinata, punto.getStato().nome, punto.getStato().tipologia, punto.getStato().descrizione);
        this._id = punto.getStato().hashCode();
    }

    public PuntoDiInteresse verifica() {
        this.stato= new Verificato(
                this.stato.getCoordinata(),
                this.stato.getNome(),
                this.stato.getTipologia(),
                this.stato.getDescrizione());
        return this;
    }
    public State getStato() {
        return stato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PuntoDiInteresse that)) return false;
        return Objects.equals(stato, that.stato);
    }

    @Override
    public int hashCode() {
        return this.stato.hashCode();
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setStato(State stato) {
        this.stato = stato;
    }


    @Override
    public String toString() {
        return "PuntoDiInteresse{" +
                "_id=" + _id +
                stato.toString()+
                '}';
    }
}
