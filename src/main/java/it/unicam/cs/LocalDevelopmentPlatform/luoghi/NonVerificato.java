package it.unicam.cs.LocalDevelopmentPlatform.luoghi;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("verificato")
public class NonVerificato extends State {
    public NonVerificato(Coordinata coordinata, String nome, TipologiaPunto tipologia, String descrizione) {
   super(coordinata, nome, tipologia, descrizione);
    }
}
