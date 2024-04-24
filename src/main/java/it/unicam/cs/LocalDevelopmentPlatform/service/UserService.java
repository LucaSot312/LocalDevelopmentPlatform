package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ItinerarioRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteUserById(int id) { userRepo.deleteById(id); }

    public User addUser(User user) {return userRepo.save(user);}

    public List<User> findAll() {return userRepo.findAll(); }

    public List<PuntoDiInteresse> mieiPunti(int id) {
//        List<PuntoDiInteresse> mieiPunti = new ArrayList<PuntoDiInteresse>();
        List<Integer> listaPunti = (userRepo.findById(id)).getIdPuntiDiInteresse();
//        for(Integer i : listaPunti){
//            PuntoDiInteresse punto = puntoDiInteresseRepo.findById(i).orElseThrow(() ->
//                    new RuntimeException("punto di interesse non trovato"));
//            mieiPunti.add(punto);
//        }
        return puntoDiInteresseRepo.findAllById(listaPunti);
    }

    public List<PuntoDiInteresse> mieiItinerari(int id) {

        List<PuntoDiInteresse> mieiPunti = new ArrayList<PuntoDiInteresse>();
        List<Integer> listaItinierari = (userRepo.findById(id)).getIdItinerari();
        for(Integer i : listaItinierari){
           mieiPunti.addAll(itinerarioService.getPuntiItinerario(i));
        }
      return mieiPunti;
    }

    public void salvaPunto(int idUtente, int idPunto) {
        userRepo.findById(idUtente).getIdPuntiDiInteresse().add(idPunto);
    }

    public void salvaItinerario(int idUtente, int idItinerario) {
        userRepo.findById(idUtente).getIdItinerari().add(idItinerario);
    }
}
