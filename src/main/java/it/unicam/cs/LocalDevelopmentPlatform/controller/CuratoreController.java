package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.State;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Verificato;
import it.unicam.cs.LocalDevelopmentPlatform.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Classe controller per la gestione del profilo Curatore
 */
@RestController
@RequestMapping("curatore")
public class CuratoreController extends ContributorController{

    public CuratoreController(PuntoDiInteresseService puntoDiInteresseService,
                              ItinerarioService itinerarioService,
                              BufferPuntiService bufferPuntiService,
                              UserService userService,
                              ContestService contestService,
                              MediaService mediaService) {
        super(puntoDiInteresseService,
                itinerarioService,
                bufferPuntiService,
                contestService,
                userService,
                mediaService
        );
    }
    /*
    Eliminazione di un punto di interesse tramite id
     */
    @PutMapping("/eliminaPunto/{id}")
    public String eliminaPunto(@PathVariable int id){ return puntoDiInteresseService.deletePunto(id);
    };
    /*
    Eliminazione di un itinerario tramite id
     */
    @PutMapping("/eliminaItinerario/{id}")
    public boolean eliminaItinerario(@PathVariable int id){return itinerarioService.deleteItinerario(id);}
    /*
    Elimina un media dato l'id
     */
    @PutMapping("/eliminaMedia/{id}")
    public Media eliminaMedia(@PathVariable int id){return mediaService.eliminaMedia(id);}
    /*
    Visualizza tutti i punti di interesse non verificati
     */
    @GetMapping("/nonVerificati")
    public List<State> getAllNotVerified(){return bufferPuntiService.getAll(); }
    /*
    Verifica un punto di interesse tramite id
     */
    @PutMapping("/verificaPunto/{id}")
    public Verificato verificaPunto(@PathVariable int id){return bufferPuntiService.verificaPunto(id); }
    /*
    Elimina un punto di interesse che è stato verificato dalla lista di punti da verificare (tramite id)
     */
    @PutMapping("/pulisciBuffer/{id}")
    public boolean pulisciBuffer(@PathVariable int id){return bufferPuntiService.pulisciBuffer(id); }
    /*
    Visualizza i punti di interesse segnalati
     */
    @GetMapping("/segnalati")
    public List<Verificato> segnalati(){return puntoDiInteresseService.getSegnalati(); }
    /*
    Rimuovi la segnalazione di un punto di interesse tramite id
     */
    @PutMapping("/rimuoviSegnalato/{id}")
    public Verificato rimuoviSegnalato(@PathVariable int id){
        return puntoDiInteresseService.removeSegnalato(id);}
}
