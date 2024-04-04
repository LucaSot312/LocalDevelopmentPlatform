package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

public class Curatore implements Utente {

    @Override
    public boolean caricaContenuto() {
        return false;
    }

    @Override
    public PuntoDiInteresse consultaContenuto(int ID) {
        return null;
    }

    @Override
    public PuntoDiInteresse[] consultaItinierario(int ID) {
        return new PuntoDiInteresse[0];
    }

    @Override
    public boolean segnalaContenuto(int ID) {
        return false;
    }
}
