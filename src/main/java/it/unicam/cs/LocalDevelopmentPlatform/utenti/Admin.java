package it.unicam.cs.LocalDevelopmentPlatform.utenti;
/*
Classe che rappresenta l'entità Admin
 */
public class Admin extends User {
    public Admin(String username, String password, Ruolo ruolo) {
        super(username, password, ruolo);
    }
}