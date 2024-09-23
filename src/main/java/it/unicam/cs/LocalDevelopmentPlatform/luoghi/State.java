package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")

/*
Entity class per la rappresentazione di un punto di interesse appena inserito dall'utente, quindi ancora da verificare
 */
public abstract class State {

    protected Coordinata coordinata;
    protected String nome;
    protected TipologiaPunto tipologia;
    protected String descrizione;

   public State(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
        this.coordinata = coordinata;
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State that)) return false;
        return Objects.equals(coordinata, that.coordinata) && Objects.equals(nome, that.nome)
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

}


