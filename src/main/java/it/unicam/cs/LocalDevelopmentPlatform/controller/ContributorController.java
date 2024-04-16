package it.unicam.cs.LocalDevelopmentPlatform.controller;


import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;

import java.util.List;

@RestController
@RequestMapping("/contributor")
public class ContributorController extends TuristaController {

    public ContributorController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        super(puntoInteresseService, itinerarioService);
    }

    @PostMapping("/caricaPunto")
    public void caricaPunto(@RequestBody PuntoDiInteresse puntoDiInteresse){
        puntoInteresseService.savePunto(puntoDiInteresse);}

    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario);}



}