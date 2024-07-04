package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ContestService;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoDiInteresseService;
import it.unicam.cs.LocalDevelopmentPlatform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    Classe controller per la gestione del profilo Turista Autenticato
 */
@RestController
@RequestMapping("turista")
public class TuristaAutenticatoController extends TuristaController{

    protected final UserService userService;
    protected final ContestService contestService;

    public TuristaAutenticatoController(PuntoDiInteresseService puntoInteresseService,
                                        ItinerarioService itinerarioService,
                                        UserService userService,
                                        ContestService contestService) {
        super(puntoInteresseService,
                itinerarioService);
        this.userService = userService;
        this.contestService = contestService;
    }
    /*
    Carica un nuovo itinerario
     */
    @PostMapping("/caricaItinerario")
    public Itinerario caricaItinerario(@RequestBody Itinerario itinerario){return itinerarioService.caricaItinerario(itinerario); }
    /*
    Salva un punto di interesse nel profilo utente
     */
    @PutMapping("/salvaPunto/{idUtente}/{idPunto}")
    public boolean salvaPunto(@PathVariable int idUtente, @PathVariable int idPunto){return userService.salvaPunto(idUtente,idPunto); }
    /*
    Visualizza i punti di interesse salvati nel profilo
     */
   @GetMapping("/mieiPunti/{id}")
    public List<PuntoDiInteresse> mieiPunti(@PathVariable int id){return userService.mieiPunti(id); }
    /*
    Salva un itinerario nel profilo utente
     */
    @PutMapping("/salvaItinerario/{idUtente}/{idItinerario}")
    public boolean salvaItinerario(@PathVariable int idUtente, @PathVariable int idItinerario){return userService.salvaItinerario(idUtente, idItinerario); }
    /*
    Visualizza gli itinerari salvati nel profilo
     */
    @GetMapping("/mieiItinierari/{id}")
    public List<Itinerario> mieiItinerari(@PathVariable int id){return userService.mieiItinerari(id); }

    @GetMapping("/contest")
    public List<Contest> contest(){return contestService.allContest();}
}
