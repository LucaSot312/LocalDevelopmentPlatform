package it.unicam.cs.LocalDevelopmentPlatform;

public class Curatore implements Utente{
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
    public boolean verificaContenuto(){
        return false;
    }
}
