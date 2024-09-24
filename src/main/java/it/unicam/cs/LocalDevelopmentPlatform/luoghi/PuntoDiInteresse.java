package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "PuntoDiInteresse")
public class PuntoDiInteresse {
    @Id
    private int  _id;

    private State stato;

    // Costruttore custom
    @JsonCreator
    public PuntoDiInteresse(@JsonProperty("stato")State stato)
    {
        this.stato = stato;
        this._id = Math.abs(hashCode());
    }

    public PuntoDiInteresse verifica() {
        this.stato= new Verificato(
                this.stato.getCoordinata(),
                this.stato.getNome(),
                this.stato.getTipologia(),
                this.stato.getDescrizione());
        return this;
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

    public State getStato() {
        return this.stato;
    }

    @Override
    public String toString() {
        return "PuntoDiInteresse{" +
                "_id=" + _id +
                stato.toString()+
                '}';
    }
}
