package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.BufferPuntiService;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoDiInteresseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    Classe controller per la gestione del profilo Curatore
 */
@RestController
@RequestMapping("curatore")
public class CuratoreController extends TuristaController{

    private final BufferPuntiService bufferPuntiService;

    public CuratoreController(PuntoDiInteresseService puntoDiInteresseService, ItinerarioService itinerarioService, BufferPuntiService bufferPuntiService) {
        super(puntoDiInteresseService, itinerarioService);
        this.bufferPuntiService = bufferPuntiService;
    }
    /*
    Eliminazione di un punto di interesse tramite id
     */
    @PutMapping("/eliminaPunto/{id}")
    public void eliminaPunto(@PathVariable int id){
        puntoDiInteresseService.deletePunto(id);
    };
    /*
    Eliminazione di un itinerario tramite id
     */
    @PutMapping("/eliminaItinerario/{id}")
    public void eliminaItinerario(@PathVariable int id){itinerarioService.deleteItinerario(id);}
    /*
    Visualizza tutti i punti di interesse non verificati
     */
    @GetMapping("/nonVerificati")
    public List<BufferPunti> getAllNotVerified(){return bufferPuntiService.getAll(); }
    /*
    Verifica un punto di interesse tramite id
     */
    @PutMapping("/verificaPunto/{id}")
    public void verificaPunto(@PathVariable int id){bufferPuntiService.verificaPunto(id); }
    /*
    Elimina un punto di interesse che è stato verificato dalla lista di punti da verificare (tramite id)
     */
    @PutMapping("/pulisciBuffer/{id}")
    public void pulisciBuffer(@PathVariable int id){bufferPuntiService.pulisciBuffer(id); }
    /*
    Visualizza i punti di interesse segnalati
     */
    @GetMapping("/segnalati")
    public List<PuntoDiInteresse> segnalati(){return puntoDiInteresseService.getSegnalati(); }
    /*
    Rimuovi la segnalazione di un punto di interesse tramite id
     */
    @PutMapping("/rimuoviSegnalato/{id}")
    public void rimuoviSegnalato(@PathVariable int id){
        puntoDiInteresseService.removeSegnalato(id);}
}
