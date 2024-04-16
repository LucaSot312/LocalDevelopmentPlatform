package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.ItinerarioService;
import it.unicam.cs.LocalDevelopmentPlatform.service.PuntoInteresseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curatore")
public class CuratoreController extends TuristaController{
    public CuratoreController(PuntoInteresseService puntoInteresseService, ItinerarioService itinerarioService) {
        super(puntoInteresseService, itinerarioService);
    }

    @PutMapping("/eliminaPunto/{id}")
    public void eliminaPunto(@PathVariable int id){
        puntoInteresseService.deletePunto(id);
    };

    @GetMapping("/nonVerificati")
    public List<PuntoDiInteresse> getAllNotVerified(){return puntoInteresseService.getAllNotVerified();}
}
