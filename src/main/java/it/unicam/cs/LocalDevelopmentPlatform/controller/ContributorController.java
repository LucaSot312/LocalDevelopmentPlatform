package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.BufferPuntiService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoDiInteresseService;
import org.springframework.web.bind.annotation.*;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
/*
    Classe controller per la gestione del profilo Contributor
 */
@RestController
@RequestMapping("contributor")
public class ContributorController extends TuristaController {

    BufferPuntiService bufferPuntiService;
    public ContributorController(PuntoDiInteresseService puntoDiInteresseService, ItinerarioService itinerarioService, BufferPuntiService bufferPuntiService) {
        super(puntoDiInteresseService, itinerarioService);
        this.bufferPuntiService=bufferPuntiService;

    }
    /*
    Caricamento di un nuovo punto di interesse in attesa di essere verificato
     */
    @PostMapping(value = "/caricaPunto")
    public void caricaPunto(@RequestBody BufferPunti punto) {
        bufferPuntiService.savePunto(punto);
    }
    /*
    Caricamento di un nuovo itinerario
     */
    @PostMapping("/caricaItinerario")
    public Itinerario caricaItinerario(@RequestBody Itinerario itinerario){return itinerarioService.caricaItinerario(itinerario);}
}