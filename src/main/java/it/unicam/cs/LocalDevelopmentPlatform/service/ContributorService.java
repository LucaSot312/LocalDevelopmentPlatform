package it.unicam.cs.LocalDevelopmentPlatform.service;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContributorRepoIT;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContributorRepoPDI;

@Service
public class ContributorService {
    private final ContributorRepoPDI contributorRepoPDI;
    private final ContributorRepoIT contributorRepoIT;
    @Autowired
    public ContributorService(ContributorRepoPDI contributorRepo, ContributorRepoIT contributorRepoIT) {
        this.contributorRepoPDI = contributorRepo;
        this.contributorRepoIT = contributorRepoIT;
    }
    public void caricaContenuto(PuntoDiInteresse puntoDiInteresse){
        contributorRepoPDI.insert(puntoDiInteresse);
    }
    public void creaItinerario(Itinerario itinerario){
        contributorRepoIT.insert(itinerario);
    }
    public void consultaContenutoById(int id){
        
    }
    public void consultaItinerario(){

    }
	public java.util.List<PuntoDiInteresse> getAllPunti() {
		return contributorRepoPDI.findAll();
    }


    // Add your service methods here
}