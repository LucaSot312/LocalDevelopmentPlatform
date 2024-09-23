package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/*
Classe astratta per la rappresentazione dello stato di un punto di interesse,
funzionale all'applicazione del design patter STATE
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Verificato.class, name = "verificato"),
        @JsonSubTypes.Type(value = NonVerificato.class, name = "nonVerificato")
})
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
        return Objects.hash(this.coordinata, this.nome, this.tipologia, this.descrizione);
    }

    public Coordinata getCoordinata() {return coordinata; }

    public String getNome() {return nome; }

    public TipologiaPunto getTipologia() {return tipologia; }

    public String getDescrizione() {return descrizione; }

    @Override
    public String toString() {
        return "State{" +
                "coordinata=" + coordinata +
                ", nome='" + nome + '\'' +
                ", tipologia=" + tipologia +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}


