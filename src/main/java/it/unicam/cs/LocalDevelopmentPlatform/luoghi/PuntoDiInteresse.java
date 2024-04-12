package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Document(collection = "PuntoDiInteresse")
public class PuntoDiInteresse {
    @Id
    private int _id;

    private Coordinata coordinata;
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

    public PuntoDiInteresse(Coordinata coordinata, String nome, TipologiaPunto tipologia, boolean verificato, boolean segnalato, String descrizione, String motivoSegnalazione) {
        this.coordinata = coordinata;
        this.nome = nome;
        this.tipologia = tipologia;
        this.verificato = verificato;
        this.segnalato = segnalato;
        this.descrizione = descrizione;
        this.motivoSegnalazione = motivoSegnalazione;
        this._id=this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinata, nome, tipologia);
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setCoordinata(Coordinata coordinata) {
        this.coordinata = coordinata;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
