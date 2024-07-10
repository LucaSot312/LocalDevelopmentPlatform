package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.service.*;

import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/aggiungiPartecipante/{idContest}/{idPartecipante}")
    public Contest aggiungiPartecipante(@PathVariable int idContest, @PathVariable int idPartecipante) {
        return contestService.aggiungiPartecipante(idContest,idPartecipante);}

    @GetMapping("/determinaVincitore/{id}")
    public List<Integer> determinaVincitore(@PathVariable int id){return contestService.determinaVincitore(id);}

    @PutMapping("/eliminaContest/{id}")
    public boolean eliminaContest(@PathVariable int id) {return contestService.eliminaContest(id);}
}

