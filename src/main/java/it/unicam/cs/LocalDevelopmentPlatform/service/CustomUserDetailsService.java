//package it.unicam.cs.LocalDevelopmentPlatform.service;
//
//import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
//import it.unicam.cs.LocalDevelopmentPlatform.utenti.CustomUserDetails;
//import it.unicam.cs.LocalDevelopmentPlatform.utenti.Utente;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    public CustomUserDetailsService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Utente utente = userRepo.findByUsername(username);
//        if(utente==null)
//            throw new UsernameNotFoundException("Utente non trovato");
//        return new CustomUserDetails(utente);
//    }
//}
