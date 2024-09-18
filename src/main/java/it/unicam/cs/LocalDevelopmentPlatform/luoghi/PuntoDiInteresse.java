package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import java.util.Objects;

public class PuntoDiInteresse {

    private State stato;

    public PuntoDiInteresse(State stato) {
        this.stato = stato;
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
        return Objects.hashCode(stato);
    }
}
