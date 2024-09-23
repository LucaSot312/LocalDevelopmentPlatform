package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import com.fasterxml.jackson.annotation.JsonTypeName;

/*
Entity class per la rappresentazione di un punto di interesse verificato
 */
@JsonTypeName("verificato")
public class Verificato extends State {
    private boolean segnalato;
    private String motivoSegnalazione;

    public Verificato(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
       super(coordinata, nome, tipologia, descrizione);
        this.segnalato = false;
        this.motivoSegnalazione = "";
    }

    public void setSegnalato(boolean segnalato) {
        this.segnalato = segnalato;
    }


    public void segnala(String motivo){
        this.motivoSegnalazione = this.motivoSegnalazione.concat(motivo+";");
        this.setSegnalato(true);
    }

    public void removeSegnalato(){
        this.setSegnalato(false);
        this.motivoSegnalazione = "";
    }

    public boolean isSegnalato() {return segnalato; }

    public String getMotivoSegnalazione() {
        return motivoSegnalazione;
    }

    public void setMotivoSegnalazione(String motivoSegnalazione) {
        this.motivoSegnalazione = motivoSegnalazione;
    }
}
