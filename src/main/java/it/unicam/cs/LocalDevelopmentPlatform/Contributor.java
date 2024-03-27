package it.unicam.cs.LocalDevelopmentPlatform;

public class Contributor implements Utente{

    @Override
    public boolean caricaContenuto() {
        return false;
    }

    public boolean creaItinerario(){
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
