package it.unicam.cs.LocalDevelopmentPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ItinerarioRepo;

import java.util.List;

@Service
public class ItinerarioService {
    private final ItinerarioRepo itinerarioRepo;
    @Autowired
    public ItinerarioService(ItinerarioRepo itinerarioRepo) {
        this.itinerarioRepo = itinerarioRepo;
    }

    public Itinerario getItinerarioById(int id){
        return itinerarioRepo.findById(id);
    }
    public List<Itinerario> getAllItinerari(){
        return itinerarioRepo.findAll();
    }
    public void saveItinerario(Itinerario itinerario) {
        itinerarioRepo.save(itinerario);
    }

}