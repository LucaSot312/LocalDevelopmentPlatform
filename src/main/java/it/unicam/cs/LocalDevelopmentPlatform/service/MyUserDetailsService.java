package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.security.AdminUserDetails;
import it.unicam.cs.LocalDevelopmentPlatform.security.ContributorUserDetails;
import it.unicam.cs.LocalDevelopmentPlatform.security.TuristaAuthUserDetails;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
Classe Service per l'implementazione delle funzionalità relative alla sicurezza dei profili utente
messe a disposizione nel Controller
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User turista = userRepo.findByUsername(username);
        if (turista != null) {
            return new TuristaAuthUserDetails(turista);
        }
        User contributor = userRepo.findByUsername(username);
        if (contributor != null) {
            return new ContributorUserDetails(contributor);
        }
        User admin = userRepo.findByUsername(username);
        if (admin != null) {
            return new AdminUserDetails(admin);
        }
        throw new UsernameNotFoundException("User not found");
    }
    private List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }


}
