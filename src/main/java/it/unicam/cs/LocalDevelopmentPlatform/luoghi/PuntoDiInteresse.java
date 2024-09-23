package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "PuntoDiInteresse")
public class PuntoDiInteresse {

    private int _id;
    private State stato;

    public PuntoDiInteresse(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione){
        this.stato = new NonVerificato(coordinata, nome, tipologia, descrizione);
        this._id =  Math.abs(hashCode());
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
        return stato.hashCode();
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
}
