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

    public List<PuntoDiInteresse> getAllPuntiById(List<Integer> punti){return puntoDiInteresseRepo.findAllById(punti);}

    public PuntoDiInteresse getPuntoByID(int id) {
        return puntoDiInteresseRepo.findById(id);
    }

    public void deletePunto(int id){puntoDiInteresseRepo.deleteById(id);}

    public void segnalaPunto(int id, String motivo) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.segnala(motivo);
        puntoDiInteresseRepo.save(temp);
    }

    public List<PuntoDiInteresse> getSegnalati() {
        return puntoDiInteresseRepo.allSegnalati();
    }

    public void removeSegnalato(int id) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.removeSegnalato();
        puntoDiInteresseRepo.save(temp);
    }
}
