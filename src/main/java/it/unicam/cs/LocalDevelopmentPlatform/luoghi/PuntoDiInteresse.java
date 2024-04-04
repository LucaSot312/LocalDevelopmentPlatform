package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import java.util.Objects;

public class PuntoDiInteresse {

    private final int id;
    private final Coordinata coordinata;
    private String nome;
    private TipologiaPunto tipologia;
    private boolean verificato;
    private boolean segnalato;
    private String descrizione;
    private String motivoSegnalazione;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PuntoDiInteresse that)) return false;
        return verificato == that.verificato && segnalato == that.segnalato && Objects.equals(coordinata, that.coordinata) && Objects.equals(nome, that.nome) && tipologia == that.tipologia && Objects.equals(descrizione, that.descrizione) && Objects.equals(motivoSegnalazione, that.motivoSegnalazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinata, nome, tipologia);
    }

    public PuntoDiInteresse(int x, int y, String nome, TipologiaPunto tipologia, String descrizione) {
        this.coordinata = new Coordinata(x,y);
        this.nome = nome;
        this.tipologia = tipologia;
        this.verificato =false;
        this.segnalato = false;
        this.descrizione = descrizione;
        this.id=hashCode();
    }

    public int getId() {
        return id;
    }

    public Coordinata getCoordinata() {
        return coordinata;
    }

    public String getNome() {
        return nome;
    }

    public TipologiaPunto getTipologia() {
        return tipologia;
    }

    public void setTipologia(TipologiaPunto tipologia) {
        this.tipologia = tipologia;
    }

    public boolean isVerificato() {
        return verificato;
    }

    public void setVerificato(boolean verificato) {
        this.verificato = verificato;
    }

    public boolean isSegnalato() {
        return segnalato;
    }

    public void setSegnalato(boolean segnalato) {
        this.segnalato = segnalato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getMotivoSegnalazione() {
        return motivoSegnalazione;
    }

    public void setMotivoSegnalazione(String motivoSegnalazione) {
        this.motivoSegnalazione = motivoSegnalazione;
    }
}
