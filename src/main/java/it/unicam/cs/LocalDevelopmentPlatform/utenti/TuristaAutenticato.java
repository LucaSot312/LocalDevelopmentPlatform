package it.unicam.cs.LocalDevelopmentPlatform.utenti;
/*
Classe che rappresenta l'entità Turista Autenticato
 */
public class TuristaAutenticato extends User implements Turista{
    public TuristaAutenticato(String username, String password, Ruolo ruolo) {
        super(username, password, ruolo);
    }
}
