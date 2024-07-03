package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.service.*;
import org.springframework.web.bind.annotation.*;

/*
    Classe controller per la gestione del profilo Contributor
 */
@RestController
@RequestMapping("contributor")
public class ContributorController extends TuristaAutenticatoController {

    protected final BufferPuntiService bufferPuntiService;

    public ContributorController(PuntoDiInteresseService puntoInteresseService,
                                 ItinerarioService itinerarioService,
                                 BufferPuntiService bufferPuntiService,
                                 ContestService contestService,
                                 UserService userService) {
        super(puntoInteresseService,
                itinerarioService,
                userService,
                contestService);
        this.bufferPuntiService=bufferPuntiService;
    }
    /*
    Caricamento di un nuovo punto di interesse in attesa di essere verificato
     */
    @PostMapping(value = "/caricaPunto")
    public BufferPunti caricaPunto(@RequestBody BufferPunti punto) {
        return bufferPuntiService.savePunto(punto);

    }
    /*
    Caricamento di un nuovo itinerario
     */
    @PostMapping("/caricaItinerario")
    public Itinerario caricaItinerario(@RequestBody Itinerario itinerario){return itinerarioService.caricaItinerario(itinerario);}
}