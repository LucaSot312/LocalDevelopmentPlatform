package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuristaService implements service {


    private final UserRepo userRepo;

    @Autowired
    public TuristaService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<PuntoDiInteresse> getAllPunti() {
        return userRepo.findAll();
        //TODO after JPA
    }

    @Override
    public PuntoDiInteresse getPuntoByID(int id) {
        return null;
        //TODO after JPA
    }

    @Override
    public List<Itinerario> getAllItinerari() {
        return null;
        //TODO after JPA
    }

    @Override
    public Itinerario getItinerarioByID(int id) {
        return null;
        //TODO after JPA
    }
}
