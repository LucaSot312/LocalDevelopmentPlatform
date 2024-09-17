package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
/*
Entity class per la rappresentazione di un punto di interesse appena inserito dall'utente, quindi ancora da verificare
 */
@Document(collection = "bufferPunti")
public abstract class State {
    @Id
    private int _id;

    private Coordinata coordinata;
    private String nome;
    private TipologiaPunto tipologia;
    private String descrizione;

    public State(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
        this.coordinata = coordinata;
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this._id = Math.abs(hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State that)) return false;
        return _id == that._id && Objects.equals(coordinata, that.coordinata) && Objects.equals(nome, that.nome)
                && tipologia == that.tipologia && Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinata, nome, tipologia, descrizione);
    }

    public Coordinata getCoordinata() {return coordinata; }

    public String getNome() {return nome; }

    public TipologiaPunto getTipologia() {return tipologia; }

    public String getDescrizione() {return descrizione; }

    public void set_id(int id){this._id = id;}

    public int get_id(){return _id;}
}


