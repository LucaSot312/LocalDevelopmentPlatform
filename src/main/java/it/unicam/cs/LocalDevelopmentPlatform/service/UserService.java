package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ItinerarioRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.Ruolo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
Classe Service per l'implementazione delle funzionalità relative alla gestione degli utenti
messe a disposizione nel Controller
 */
@Service
public class UserService{


    private final UserRepo userRepo;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;
    private final ItinerarioRepo itinerarioRepo;
    private final ItinerarioService itinerarioService;

    @Autowired
    public UserService(UserRepo userRepo, PuntoDiInteresseRepo puntoDiInteresseRepo, ItinerarioRepo itinerarioRepo, ItinerarioService itinerarioService) {
        this.userRepo = userRepo;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
        this.itinerarioRepo = itinerarioRepo;
        this.itinerarioService = itinerarioService;
    }

    public User loadUserByUsername(String username) { return userRepo.findByUsername(username); }

    public User findUserById(int id) { return userRepo.findById(id); }

    public boolean eliminaUtente(int id) {
        if(userRepo.findById(id).getRuolo()== Ruolo.ADMIN) {
            return false;
        }else{
            userRepo.deleteById(id);
            return true;
        }

    }

    public User addUser(User user) {return userRepo.save(user);}

    public List<User> findAll() {return userRepo.findAllNotAdmin(); }

    public List<PuntoDiInteresse> mieiPunti(int id) {
        List<Integer> listaPunti = (userRepo.findById(id)).getIdPuntiDiInteresse();
        return puntoDiInteresseRepo.findAllById(listaPunti);
    }

    public List<Itinerario> mieiItinerari(int id) {
        List<Integer> listaItinierari = (userRepo.findById(id)).getIdItinerari();
        return itinerarioRepo.findAllById(listaItinierari);
    }

    public boolean salvaPunto(int idUtente, int idPunto) {
        userRepo.findById(idUtente).getIdPuntiDiInteresse().add(idPunto);
        return userRepo.findById(idUtente).getIdPuntiDiInteresse().contains(idPunto);
    }

    public boolean salvaItinerario(int idUtente, int idItinerario) {
        userRepo.findById(idUtente).getIdItinerari().add(idItinerario);
        return userRepo.findById(idUtente).getIdItinerari().contains(idItinerario);
    }
    public boolean cambiaRuolo(int idUtente, Ruolo ruolo){
        userRepo.findById(idUtente).setRuolo(ruolo);
        return userRepo.findById(idUtente).getRuolo().equals(ruolo);

    }
}
