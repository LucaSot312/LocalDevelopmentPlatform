package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Document(collection = "Utenti")
public class User implements UserDetails{
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
