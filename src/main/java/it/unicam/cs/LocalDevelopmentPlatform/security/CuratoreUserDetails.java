package it.unicam.cs.LocalDevelopmentPlatform.security;

import it.unicam.cs.LocalDevelopmentPlatform.utenti.Curatore;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CuratoreUserDetails implements UserDetails {
    private final User curatore;

    public CuratoreUserDetails(User curatore) {
        this.curatore = curatore;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("CURATORE"));
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
