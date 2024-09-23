package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.State;
import it.unicam.cs.LocalDevelopmentPlatform.service.*;
import org.springframework.web.bind.annotation.*;

/*
    Classe controller per la gestione del profilo Contributor
 */
@RestController
@RequestMapping("contributor")
public class ContributorController extends TuristaAutenticatoController {

    public ContributorController(PuntoDiInteresseService puntoInteresseService,
                                 ItinerarioService itinerarioService,
                                 ContestService contestService,
                                 UserService userService,
                                 MediaService mediaService) {
        super(puntoInteresseService,
                itinerarioService,
                userService,
                contestService,
                mediaService);

    }
    /*
    Caricamento di un nuovo punto di interesse in attesa di essere verificato
     */
    @PostMapping(value = "/caricaPunto")
    public PuntoDiInteresse caricaPunto(@RequestBody PuntoDiInteresse punto) {
        System.out.println("ID PUNTO: "+punto.get_id());
        return puntoDiInteresseService.salvaPunto(punto);

    }
}