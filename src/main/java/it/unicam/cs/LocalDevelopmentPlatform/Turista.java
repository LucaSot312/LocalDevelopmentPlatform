package it.unicam.cs.LocalDevelopmentPlatform;

public class Turista implements Utente {

    @Override
    public boolean inserisciContenuto() {
        return false;
    }

    @Override
    public PuntoDiInteresse visualizzaContenuto() {
        return null;
    }

    @Override
    public PuntoDiInteresse[] visualizzaItinerario() {
        return new PuntoDiInteresse[0];
    }

    @Override
    public boolean segnalaContenuto() {
        return false;
    }
}
