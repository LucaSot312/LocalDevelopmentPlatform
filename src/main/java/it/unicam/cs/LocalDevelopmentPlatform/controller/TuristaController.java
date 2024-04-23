package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class TuristaController {

    protected final PuntoInteresseService puntoInteresseService;
    protected final ItinerarioService itinerarioService;

    @Autowired
    public TuristaController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        this.puntoInteresseService = puntoInteresseService;
        this.itinerarioService = itinerarioService;
    }

    @GetMapping("/punti")
    public List<PuntoDiInteresse> getAllPunti() { return puntoInteresseService.getAllPunti(); }

    @GetMapping("/punto/{id}")
    public PuntoDiInteresse getPuntoById(@PathVariable int id) {
        return puntoInteresseService.getPuntoByID(id);
    }

    @GetMapping("/itinerari")
    public List<Itinerario> getAllItinerari() {
        return itinerarioService.getAllItinerari();
    }

    @GetMapping("/itinerario/{id}")
    public List<PuntoDiInteresse> getItinerarioByID(@PathVariable int id) {
        return itinerarioService.getPuntiItinerario(id);

        //TODO se rimane tempo implementiamo un nuovo oggetto atto a far vedere nome e descrizione dell itinerario
        // quando fetchamo dal database
    }
}
