package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turista")
public class TuristaController {

    private final PuntoInteresseService puntoInteresseService;
    private final ItinerarioService itinerarioService;

    @Autowired
    public TuristaController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        this.puntoInteresseService = puntoInteresseService;
        this.itinerarioService = itinerarioService;
    }

    // Example GET endpoint
    @GetMapping("/fetch")
    public List<PuntoDiInteresse> getAllPunti() {
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

    // Example POST endpoint with request body
}
