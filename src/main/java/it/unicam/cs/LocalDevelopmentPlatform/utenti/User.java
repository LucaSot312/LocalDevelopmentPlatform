package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;
/*
Classe che rappresenta l'entità User da cui derivano le altre classi che vanno a specializzarla
 */
@Document(collection = "Utenti")
public class User{
    @Id
    private int _id;

    private final String username;
    private final String password;
    private Ruolo ruolo;
    private ArrayList<Integer> idPuntiDiInteresse;
    private ArrayList<Integer> idItinerari;

    public User(String username, String password, Ruolo ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
        this.idPuntiDiInteresse=new ArrayList<>();
        this.idItinerari=new ArrayList<>();
        this._id = this.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return _id == user._id && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && ruolo == user.ruolo;
    }

    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(getUsername(), getPassword(), ruolo));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public ArrayList<Integer> getIdPuntiDiInteresse() {
        return idPuntiDiInteresse;
    }

    public void setIdPuntiDiInteresse(ArrayList<Integer> idPuntiDiInteresse) {
        this.idPuntiDiInteresse = idPuntiDiInteresse;
    }

    public ArrayList<Integer> getIdItinerari() {
        return idItinerari;
    }

    public void setIdItinerari(ArrayList<Integer> idItinerari) {
        this.idItinerari = idItinerari;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
