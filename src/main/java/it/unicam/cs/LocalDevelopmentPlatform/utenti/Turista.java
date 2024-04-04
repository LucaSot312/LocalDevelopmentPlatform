package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

public abstract class Turista implements Utente {

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

    public boolean segnalaContenuto(int ID) {
        return false;
    }


}
