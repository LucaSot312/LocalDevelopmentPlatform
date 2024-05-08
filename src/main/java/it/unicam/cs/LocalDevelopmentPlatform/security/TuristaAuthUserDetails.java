package it.unicam.cs.LocalDevelopmentPlatform.security;

import it.unicam.cs.LocalDevelopmentPlatform.utenti.TuristaAutenticato;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
/*
Classe per l'implementazione della sicurezza del Turista Autenticato
 */
public class TuristaAuthUserDetails implements UserDetails {
    private final User turistaAutenticato;

    public TuristaAuthUserDetails(User turistaAutenticato) {
        this.turistaAutenticato = turistaAutenticato;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("TURISTA"));
    }

    @Override
    public String getPassword() {
        return turistaAutenticato.getPassword();
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
