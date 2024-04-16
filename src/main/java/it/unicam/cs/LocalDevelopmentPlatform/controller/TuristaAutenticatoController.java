package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authTurista")
public class TuristaAutenticatoController extends TuristaController{

    public TuristaAutenticatoController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService, ItinerarioService itinerarioService1, PuntoInteresseService puntoInteresseService1) {
        super(puntoInteresseService, itinerarioService);
    }

    @PostMapping("/caricaPunto")
    public void caricaPunto(@RequestBody PuntoDiInteresse puntoDiInteresse){
        super.puntoInteresseService.savePunto(puntoDiInteresse);}

    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario);}
}
