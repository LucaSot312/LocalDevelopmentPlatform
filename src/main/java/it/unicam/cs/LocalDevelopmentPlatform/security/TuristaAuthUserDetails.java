package it.unicam.cs.LocalDevelopmentPlatform.security;

import it.unicam.cs.LocalDevelopmentPlatform.utenti.Turista;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.TuristaAutenticato;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TuristaAuthUserDetails implements UserDetails {
    private final TuristaAutenticato turistaAutenticato;

    public TuristaAuthUserDetails(TuristaAutenticato turistaAutenticato) {
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
