package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.service.*;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
    Classe controller per la gestione del profilo Animatore
 */
@RestController
@RequestMapping("Animatore")
public class AnimatoreController extends TuristaAutenticatoController {

    public AnimatoreController(PuntoDiInteresseService puntoInteresseService,
                               ItinerarioService itinerarioService,
                               ContestService contestService,
                               UserService userService,
                               MediaService mediaService) {
        super( puntoInteresseService,
                itinerarioService,
                userService,
                contestService,
                mediaService
                );
    }

    @PostMapping("/bandisciContest")
    public Contest bandisciContest(@RequestBody Contest contest) {return contestService.bandisciContest(contest); }

    @PutMapping("/aggiungiPartecipanti/{id}")
    public Contest aggiungiPartecipanti(@PathVariable int id,@RequestBody ArrayList<Integer> partecipantiAggiuntivi) {
        //TODO metodo non funzionante a causa di databind errati di JacksonData
        return contestService.aggiungiPartecipanti(id,partecipantiAggiuntivi);}

    @GetMapping("/determinaVincitore/{id}")
    public List<User> determinaVincitore(@PathVariable int id){return contestService.determinaVincitore(id);}

    @PutMapping("/eliminaContest/{id}")
    public boolean eliminaContest(@PathVariable int id) {return contestService.eliminaContest(id);}
}

