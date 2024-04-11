package it.unicam.cs.LocalDevelopmentPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ItinerarioRepo;

@Service
public class ContributorService {
    private final ItinerarioRepo itinerarioRepo;
    @Autowired
    public ContributorService(ItinerarioRepo itinerarioRepo) {
        this.itinerarioRepo = itinerarioRepo;
    }
    public void caricaContenuto(PuntoDiInteresse puntoDiInteresse){}
    public void creaItinerario(Itinerario itinerario){}
    public void consultaContenutoById(int id){
        
    }
    public void consultaItinerario(){

    }
	public java.util.List<PuntoDiInteresse> getAllPunti() {
        return java.util.List.of();
    }


    // Add your service methods here
}