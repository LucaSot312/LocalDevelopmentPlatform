package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.service.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class TuristaController {

    private final TuristaService turistaService;

    @Autowired
    public TuristaController(TuristaService turistaService) {
        this.turistaService = turistaService;
    
    }

    // Example GET endpoint
    @GetMapping("")
    public List<PuntoDiInteresse> getAllPunti() {
        return turistaService.getAllPunti();
    }

    @GetMapping("/punto/{id}")
    public PuntoDiInteresse getPuntoById(@PathVariable int id) {
        return turistaService.getPuntoByID(id);
    }

    @GetMapping("/itinerario")
    public List<Itinerario> getAllItinerari() {
        return turistaService.getAllItinerari();
    }

    @GetMapping("/itinerario/{id}")
    public Itinerario getItinerarioByID(@PathVariable int id) {
        return turistaService.getItinerarioByID(id);
    }



    // Example POST endpoint with request body
    @PostMapping("/example")
    public String postExample(@RequestBody String requestBody) {
        return "Received POST request with body: " + requestBody;
    }

    // Example GET endpoint with path variable
    @GetMapping("/example/{id}")
    public String getExampleById(@PathVariable Long id) {
        return "Received GET request for ID: " + id;
    }

    // Example PUT endpoint with path variable and request body
    @PutMapping("/example/{id}")
    public String putExampleById(@PathVariable Long id, @RequestBody String requestBody) {
        return "Received PUT request for ID: " + id + " with body: " + requestBody;
    }

    // Example DELETE endpoint with path variable
    @DeleteMapping("/example/{id}")
    public String deleteExampleById(@PathVariable Long id) {
        return "Received DELETE request for ID: " + id;
    }
}
