package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.BufferPuntiService;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curatore")
@PreAuthorize("hasRole('CURATORE')")
public class CuratoreController extends TuristaController{

    private final BufferPuntiService bufferPuntiService;

    public CuratoreController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService, BufferPuntiService bufferPuntiService) {
        super(puntoInteresseService, itinerarioService);
        this.bufferPuntiService = bufferPuntiService;
    }

    @PutMapping("/eliminaPunto/{id}")
    public void eliminaPunto(@PathVariable int id){
        puntoInteresseService.deletePunto(id);
    };

    @PutMapping("/eliminaItinerario/{id}")
    public void eliminaItinerario(@PathVariable int id){itinerarioService.deleteItinerario(id);}

    @GetMapping("/nonVerificati")
    public List<BufferPunti> getAllNotVerified(){return bufferPuntiService.getAll(); }

    @PutMapping("/verificaPunto/{id}")
    public void verificaPunto(@PathVariable int id){bufferPuntiService.verificaPunto(id); }

    @PutMapping("/pulisciBuffer/{id}")
    public void pulisciBuffer(@PathVariable int id){bufferPuntiService.pulisciBuffer(id); }

    @GetMapping("/segnalati")
    public List<PuntoDiInteresse> segnalati(){return puntoInteresseService.getSegnalati(); }

    @PutMapping("/rimuoviSegnalato/{id}")
    public void rimuoviSegnalato(@PathVariable int id){puntoInteresseService.removeSegnalato(id);}
}
