package it.unicam.cs.LocalDevelopmentPlatform.controller;

import java.util.List;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;

@RestController
@RequestMapping("/contributor")
public class ContributorController {

    @Autowired
    private final ItinerarioService itinerarioService;
    private final PuntoInteresseService puntoInteresseService;

    public ContributorController(ItinerarioService itinerarioService, PuntoInteresseService puntoInteresseService) {
        this.itinerarioService = itinerarioService;
        this.puntoInteresseService = puntoInteresseService;
    }

     //GET endpoint
     @GetMapping("/fetch")
     public List<PuntoDiInteresse> getAllPunti(){
         return puntoInteresseService.getAllPunti();
     }
    @GetMapping("/punto/{id}")
    public PuntoDiInteresse getPuntoById(@PathVariable int id) {
        return puntoInteresseService.getPuntoByID(id);
    }

    @GetMapping("/itinerario")
    public List<Itinerario> getAllItinerari() {
        return itinerarioService.getAllItinerari();
    }

    @GetMapping("/itinerario/{id}")
    public Itinerario getItinerarioByID(@PathVariable int id) {
        return itinerarioService.getItinerarioById(id);
    }
    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario);}

}