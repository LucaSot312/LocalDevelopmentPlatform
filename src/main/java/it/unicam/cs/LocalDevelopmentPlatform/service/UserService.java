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
    /*
    Restituisce un utente dato l'username
     */
    public User findByUsername(String username) { return userRepo.findByUsername(username); }
    /*
    Restituisce un utente dato l'username
     */
    public User findById(int id) { return userRepo.findById(id); }
    /*
    Elimina un utente dato l'username
     */
    public boolean eliminaUtente(int id) {
        if(userRepo.findById(id).getRuolo()== Ruolo.ADMIN) {
            return false;
        }else{
            userRepo.deleteById(id);
            return true;
        }

    }
    /*
    Aggiunge un nuovo utente
     */
    public User addUser(User user) {return userRepo.save(user);}
    /*
    Restituisce tutti gli utenti che non sono admin
     */
    public List<User> findAll() {return userRepo.findAllNotAdmin(); }
    /*
    Restituisce i punti di interesse salvati nel profilo utente
     */
    public List<PuntoDiInteresse> mieiPunti(int id) {
        List<Integer> listaPunti = (userRepo.findById(id)).getIdPuntiDiInteresse();
        return puntoDiInteresseRepo.findAllById(listaPunti);
    }
    /*
        Restituisce gli itinerari salvati nel profilo utente

     */
    public List<Itinerario> mieiItinerari(int id) {
        List<Integer> listaItinierari = (userRepo.findById(id)).getIdItinerari();
        return itinerarioRepo.findAllById(listaItinierari);
    }
    /*
    Salva un punto di interesse nel profilo utente
     */
    public boolean salvaPunto(int idUtente, int idPunto) {
        User user=userRepo.findById(idUtente);
        ArrayList<Integer> idPunti=user.getIdPuntiDiInteresse();
        idPunti.add(idPunto);
        user.setIdPuntiDiInteresse(idPunti);
        userRepo.deleteById(idUtente);
        userRepo.save(user);
        return userRepo.findById(idUtente).getIdPuntiDiInteresse().contains(idPunto);
    }
    /*
    Salva un itinerario nel profilo utente
     */
    public boolean salvaItinerario(int idUtente, int idItinerario) {
        User user=userRepo.findById(idUtente);
        ArrayList<Integer> idItinerari=user.getIdItinerari();
        idItinerari.add(idItinerario);
        user.setIdItinerari(idItinerari);
        userRepo.deleteById(idUtente);
        userRepo.save(user);
        return userRepo.findById(idUtente).getIdItinerari().contains(idItinerario);
    }
    /*
    Cambia il ruolo di un utente
     */
    public User cambiaRuolo(int idUtente, Ruolo ruolo){
        User user=userRepo.findById(idUtente);
        user.setRuolo(ruolo);
        userRepo.deleteById(idUtente);
        return userRepo.save(user);
    }
    /*
    Metodo utility che presa una lista di utenti (id) rimuove dalla lista gli utenti non più presenti nella piattaforma
     */
    public ArrayList<Integer> filtraUtenti(ArrayList<Integer> listaPartecipanti) {
        listaPartecipanti.removeIf(num -> userRepo.findById(num).isEmpty());
        return listaPartecipanti;
    }

//    public creaUtente(){
//
//    }
}
