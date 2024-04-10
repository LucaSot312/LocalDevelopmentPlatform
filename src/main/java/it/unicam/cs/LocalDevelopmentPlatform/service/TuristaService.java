package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.TuristaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuristaService{


    private final TuristaRepo turistaRepo;

    @Autowired
    public TuristaService(TuristaRepo userRepo) {
        this.turistaRepo = userRepo;
    }

    public List<PuntoDiInteresse> getAllPunti() {
        return turistaRepo.findAll();
    }

    public PuntoDiInteresse getPuntoByID(int id) {
        return turistaRepo.findById(id).orElse(null);
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
