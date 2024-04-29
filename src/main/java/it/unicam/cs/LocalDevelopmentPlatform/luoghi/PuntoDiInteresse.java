package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PuntoDiInteresse")
public class PuntoDiInteresse extends BufferPunti {

    private boolean verificato;
    private boolean segnalato;
    private String motivoSegnalazione;

    public PuntoDiInteresse(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
        super(coordinata, nome, tipologia, descrizione);
        this.verificato = true;
        this.segnalato = false;
        this.motivoSegnalazione = "";
        super.set_id(Math.abs(super.hashCode()));
    }

    public void setSegnalato(boolean segnalato) {
        this.segnalato = segnalato;
    }

    public void setVerificato(boolean verificato) {
        this.verificato = verificato;
    }

    public void segnala(String motivo){
        this.motivoSegnalazione = motivo;
        this.setSegnalato(true);
    }

    public void removeSegnalato(){
        this.segnalato = false;
        this.motivoSegnalazione = "";
    }
    public boolean isVerificato() {return verificato; }

    public boolean isSegnalato() {return segnalato; }

    public void segnala(){ this.segnalato= true; }

    public String getMotivoSegnalazione() {
        return motivoSegnalazione;
    }

    public void setMotivoSegnalazione(String motivoSegnalazione) {
        this.motivoSegnalazione = motivoSegnalazione;
    }
}
