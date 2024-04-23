package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authTurista")
public class TuristaAutenticatoController extends TuristaController{

    public TuristaAutenticatoController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        super(puntoInteresseService, itinerarioService);
    }

    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario);}

    // TODO sezione profilazione, o anche no volendo

    //TODO metodo salva punto nel profilo

    //TODO metodo get tutti i punti salvati

    //TODO metodo salva itinerario

    //TODO metodo get tutti gli itinerari salvati
}
