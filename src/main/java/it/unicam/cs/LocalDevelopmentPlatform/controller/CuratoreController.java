package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
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
                              UserService userService,
                              ContestService contestService,
                              MediaService mediaService) {
        super(puntoDiInteresseService,
                itinerarioService,
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
    public boolean eliminaItinerario(@PathVariable int id){return itinerarioService.eliminaItinerario(id);}
    /*
    Elimina un media dato l'id
     */
    @PutMapping("/eliminaMedia/{id}")
    public Media eliminaMedia(@PathVariable int id){return mediaService.eliminaMedia(id);}
    /*
    Visualizza tutti i punti di interesse non verificati
     */
    @GetMapping("/nonVerificati")
    public List<PuntoDiInteresse> puntiNonVerificati(){return puntoDiInteresseService.getAllPuntiNonVerificati(); }
    /*
    Verifica un punto di interesse tramite id
     */
    @PutMapping("/verificaPunto/{id}")
    public PuntoDiInteresse verificaPunto(@PathVariable int id){return puntoDiInteresseService.verificaPunto(id); }
    /*
    Visualizza i punti di interesse segnalati
     */
    @GetMapping("/segnalati")
    public List<PuntoDiInteresse> puntiSegnalati(){return puntoDiInteresseService.getSegnalati(); }
    /*
    Rimuovi la segnalazione di un punto di interesse tramite id
     */
    @PutMapping("/rimuoviSegnalato/{id}")
    public PuntoDiInteresse rimuoviSegnalato(@PathVariable int id){
        return puntoDiInteresseService.removeSegnalato(id);}
}
