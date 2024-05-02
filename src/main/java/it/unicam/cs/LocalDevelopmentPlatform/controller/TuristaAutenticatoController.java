package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import it.unicam.cs.LocalDevelopmentPlatform.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turista")
@PreAuthorize("hasRole('TURISTA')")
public class TuristaAutenticatoController extends TuristaController{

    private final UserService userService;

    public TuristaAutenticatoController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService, UserService userService) {
        super(puntoInteresseService, itinerarioService);
        this.userService = userService;
    }

    @PostMapping("/caricaItinerario")
    public void caricaItinerario(@RequestBody Itinerario itinerario){itinerarioService.saveItinerario(itinerario); }

    @PutMapping("/salvaPunto/{idUtente}/{idPunto}")
    public void salvaPunto(@PathVariable int idUtente, @PathVariable int idPunto){userService.salvaPunto(idUtente,idPunto); }

   @GetMapping("/mieiPunti/{id}")
    public List<PuntoDiInteresse> mieiPunti(@PathVariable int id){return userService.mieiPunti(id); }

    @PutMapping("/salvaItinerario/{idUtente}/{idItinerario}")
    public void salvaItinerario(@PathVariable int idUtente, @PathVariable int idItinerario){userService.salvaItinerario(idUtente, idItinerario); }

    @GetMapping("/mieiItinierari/{id}")
    public List<PuntoDiInteresse> mieiItinerari(@PathVariable int id){return userService.mieiItinerari(id); }
}
