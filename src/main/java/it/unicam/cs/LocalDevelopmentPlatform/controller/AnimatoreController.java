package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.service.ContestService;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Animatore")
public class AnimatoreController extends TuristaController {

    private final ContestService contestService;

    public AnimatoreController(PuntoInteresseService puntoInteresseService,
                               ItinerarioService itinerarioService,
                               ContestService contestService) {
        super(puntoInteresseService, itinerarioService);
        this.contestService = contestService;
    }

    @PostMapping("/bandisciContest")
    public Contest bandisciContest(@RequestBody Contest contest) {return contestService.bandisciContest(contest); }

    @PutMapping("/aggiungiPartecipanti/{id}")
    public Contest aggiungiPartecipanti(@PathVariable int id,@RequestBody ArrayList<Integer> partecipantiAggiuntivi) {
        //TODO metodo non funzionante a causa di databind errati di JacksonData
        return contestService.aggiungiPartecipanti(id,partecipantiAggiuntivi);}

    @GetMapping("/determinaVincitore")
    public User determinaVincitore(@PathVariable int id){return contestService.determinaVincitore(id);}

    @PutMapping("/delContest/{id}")
    public void eliminaContest(@PathVariable int id) {contestService.delContest(id);}
}

