package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoInteresseService {


    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    @Autowired
    public PuntoInteresseService(PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }

    public List<PuntoDiInteresse> getAllPunti() {
        return puntoDiInteresseRepo.findAll();
    }

    public PuntoDiInteresse getPuntoByID(int id) {
        return puntoDiInteresseRepo.findById(id);
    }

    public void savePunto(PuntoDiInteresse puntoDiInteresse) {
        puntoDiInteresseRepo.save(puntoDiInteresse);
    }

    public void deletePunto(int id){puntoDiInteresseRepo.deleteById(id);}

    public List<PuntoDiInteresse> getAllNotVerified() {
        return puntoDiInteresseRepo.findAllFalse();
    }

    public void verificaPunto(int id) {
        PuntoDiInteresse daVer = puntoDiInteresseRepo.findById(id);
        daVer.verifica();
        puntoDiInteresseRepo.deleteById(id);
        puntoDiInteresseRepo.save(daVer);
    }
}
