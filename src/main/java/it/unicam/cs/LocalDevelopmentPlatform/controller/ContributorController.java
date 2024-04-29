package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.BufferPuntiService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;


@RestController
@RequestMapping("contributor")
public class ContributorController extends TuristaController {

    BufferPuntiService bufferPuntiService;
    public ContributorController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService, BufferPuntiService bufferPuntiService) {
        super(puntoInteresseService, itinerarioService);
        this.bufferPuntiService=bufferPuntiService;

    }

    @PostMapping(value = "/caricaPunto")
    public void caricaPunto(@RequestBody BufferPunti punto) {
        bufferPuntiService.savePunto(punto);
    }

    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario);}
}