package it.unicam.cs.LocalDevelopmentPlatform.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;

@RestController
@RequestMapping("contributor")
public class ContributorController extends TuristaController {

    public ContributorController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        super(puntoInteresseService, itinerarioService);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/caricaPunto")
    public void caricaPunto(@RequestBody PuntoDiInteresse puntoDiInteresse) {
        puntoInteresseService.savePunto(puntoDiInteresse);
    }

    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario);}
}