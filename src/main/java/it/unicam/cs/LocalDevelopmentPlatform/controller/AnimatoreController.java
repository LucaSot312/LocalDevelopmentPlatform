package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.service.ContestService;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Animatore")
@PreAuthorize("hasRole('ANIMATORE')")
public class AnimatoreController extends TuristaController {

    private final ContestService contestService;


    public AnimatoreController(PuntoInteresseService puntoInteresseService,
                               ItinerarioService itinerarioService,
                               ContestService contestService) {
        super(puntoInteresseService, itinerarioService);
        this.contestService = contestService;
    }

    @PostMapping("/bandisciContest")
    public Contest bandisciContest(@RequestBody Contest contest) {return null
    //TODO da impl dopo aver fatto nel service}
}
