package it.unicam.cs.LocalDevelopmentPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

import it.unicam.cs.LocalDevelopmentPlatform.service.ContributorService;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.Contributor;

@RestController
@RequestMapping("/contributor")
public class ContributorController {

    @Autowired
    private final ContributorService contributorService;
    public ContributorController(ContributorService contributorService) {
        this.contributorService = contributorService;
    }
    
    // Add your request mapping methods here

     // Example GET endpoint
     @GetMapping("/fetch")
     public List<PuntoDiInteresse> getAllPunti(){
         return contributorService.getAllPunti();
     }
}