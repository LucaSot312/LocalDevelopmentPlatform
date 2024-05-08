package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
    Classe controller per la gestione del profilo Turista
 */
@RestController
@RequestMapping("/home")
public class TuristaController {

    protected final PuntoInteresseService puntoInteresseService;
    protected final ItinerarioService itinerarioService;

    @Autowired
    public TuristaController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        this.puntoInteresseService = puntoInteresseService;
        this.itinerarioService = itinerarioService;
    }
    /*
    Visualizza tutti i punti di interesse esistenti
     */
    @GetMapping("/punti")
    public List<PuntoDiInteresse> getAllPunti() { return puntoInteresseService.getAllPunti(); }
    /*
    Visualizza un punto di interesse tramite id
     */
    @GetMapping("/punto/{id}")
    public PuntoDiInteresse getPuntoById(@PathVariable int id) {
        return puntoInteresseService.getPuntoByID(id);
    }
    /*
    Visualizza tutti gli itinerari esistenti
     */
    @GetMapping("/itinerari")
    public List<Itinerario> getAllItinerari() {
        return itinerarioService.getAllItinerari();
    }
    /*
    Visualizza un itinerario tramite id
     */
    @GetMapping("/itinerario/{id}")
    public List<PuntoDiInteresse> getItinerarioByID(@PathVariable int id) {
        return itinerarioService.getPuntiItinerario(id);
    }
    /*
    Segnala un punto di interesse fornendo un motivo
     */
    @PutMapping("/segnalaPunto/{id}/{motivo}")
    public void segnalaPunto(@PathVariable int id, @PathVariable String motivo){
        puntoInteresseService.segnalaPunto(id,motivo);
    }
}
