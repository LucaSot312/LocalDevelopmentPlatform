package it.unicam.cs.LocalDevelopmentPlatform.service;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContributorRepo;

@Service
public class ContributorService {
    private final ContributorRepo contributorRepo;
    @Autowired
    public ContributorService(ContributorRepo contributorRepo) {
        this.contributorRepo = contributorRepo;
    }
    public void caricaContenuto(PuntoDiInteresse puntoDiInteresse){
        contributorRepo.insert(puntoDiInteresse);
    }
    public void creaItinerario(Itinerario itinerario){
        contributorRepo.insert(itinerario);
    }
    public void consultaContenutoById(int id){
        
    }
    public void consultaItinerario(){

    }


    // Add your service methods here
}