package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuristaService{

    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    @Autowired
    public TuristaService(PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }

    public List<PuntoDiInteresse> getAllPunti() {
        return puntoDiInteresseRepo.findAll();
        //TODO after JPA
    }

    public PuntoDiInteresse getPuntoByID(int id) {
        return null;
        //TODO after JPA
    }

    public List<Itinerario> getAllItinerari() {
        return null;
        //TODO after JPA
    }

    public Itinerario getItinerarioByID(int id) {
        return null;
        //TODO after JPA
    }
}
