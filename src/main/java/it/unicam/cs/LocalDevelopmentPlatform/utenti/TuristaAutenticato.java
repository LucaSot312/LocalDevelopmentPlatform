package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

public class TuristaAutenticato extends Turista {

    public TuristaAutenticato(String username, String password, Ruolo ruolo) {
        super(username, password, ruolo);
    }

    @Override
    public boolean caricaContenuto() {
        return super.caricaContenuto();
    }

    @Override
    public PuntoDiInteresse consultaContenuto(int ID) {
        return super.consultaContenuto(ID);
    }

    @Override
    public PuntoDiInteresse[] consultaItinierario(int ID) {
        return super.consultaItinierario(ID);
    }

    @Override
    public boolean segnalaContenuto(int ID) {
        return super.segnalaContenuto(ID);
    }
}
