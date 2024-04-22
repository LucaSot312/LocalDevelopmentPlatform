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
        return verificato == that.verificato && segnalato == that.segnalato && Objects.equals(coordinata, that.coordinata)
                && Objects.equals(nome, that.nome) && tipologia == that.tipologia && Objects.equals(descrizione, that.descrizione)
                && Objects.equals(motivoSegnalazione, that.motivoSegnalazione);
    }

    public PuntoDiInteresse(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
        //TODO bisogna vedere come mai il deserializzatore bypassi totalmente questo costruttore quando va a creare un'istanza
        // e quindi si può fare injection e forzare il campo a true del verificato e del segnalato.
        this.coordinata = coordinata;
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.setMotivoSegnalazione(null);
        this.setVerificato(false);
        this.setSegnalato(false);
        this._id = this.hashCode();
    }

    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(coordinata, nome, tipologia, descrizione));
    }

    public int get_id() {
        return _id;
    }

    public void setSegnalato(boolean segnalato) {
        this.segnalato = segnalato;
    }

    public void setVerificato(boolean verificato) {
        this.verificato = verificato;
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

    public boolean isVerificato() {return verificato; }

    public void verifica(){ this.verificato = true; }

    public boolean isSegnalato() {return segnalato; }

    public void segnala(){ this.segnalato= true; }

    public String getDescrizione() {
        return descrizione;
    }

    public String getMotivoSegnalazione() {
        return motivoSegnalazione;
    }

    public void setMotivoSegnalazione(String motivoSegnalazione) {
        this.motivoSegnalazione = motivoSegnalazione;
    }
}
