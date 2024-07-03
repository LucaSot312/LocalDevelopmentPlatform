package it.unicam.cs.LocalDevelopmentPlatform.utenti;
/*
Classe che rappresenta l'entità Contributor
 */
public class Contributor extends TuristaAutenticato {

    public Contributor(String username, String password, Ruolo ruolo) {
        super(username, password, ruolo);
    }
}