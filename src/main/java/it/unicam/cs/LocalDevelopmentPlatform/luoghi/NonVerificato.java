package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import com.fasterxml.jackson.annotation.JsonTypeName;

/*
Entity class per la rappresentazione di un punto di interesse non verificato
 */
@JsonTypeName("nonVerificato")
public class NonVerificato extends State {
    public NonVerificato(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
   super(coordinata, nome, tipologia, descrizione);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Coordinata getCoordinata() {
        return super.getCoordinata();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public TipologiaPunto getTipologia() {
        return super.getTipologia();
    }

    @Override
    public String getDescrizione() {
        return super.getDescrizione();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
