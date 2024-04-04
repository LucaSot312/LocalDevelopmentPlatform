package it.unicam.cs.LocalDevelopmentPlatform;

public interface Utente{
    Ruolo ruolo = null;
    boolean caricaContenuto();

    PuntoDiInteresse consultaContenuto(int ID);
    PuntoDiInteresse[] consultaItinierario(int ID);
    boolean segnalaContenuto(int ID);

}
