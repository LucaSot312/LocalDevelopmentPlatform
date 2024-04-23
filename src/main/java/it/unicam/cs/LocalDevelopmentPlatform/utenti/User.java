package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Document(collection = "Utenti")
public class User {
    @Id
    private int _id;
    private final String username;
    private final String password;
    private final Ruolo ruolo;

    public User(Utente user, String username, String password, Ruolo ruolo) {
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return "";
    }

    public String getUsername() {
        return "";
    }

}
