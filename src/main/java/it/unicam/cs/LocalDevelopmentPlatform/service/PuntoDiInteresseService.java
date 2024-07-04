package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
Classe Service per l'implementazione delle funzionalità relative ai punti di interesse
verificati messe a disposizione nel Controller
 */
@Service
public class PuntoDiInteresseService {


    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    @Autowired
    public PuntoDiInteresseService(PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }

    public List<PuntoDiInteresse> getAllPunti() {
        return puntoDiInteresseRepo.findAll();
    }

    public List<PuntoDiInteresse> getAllPuntiById(List<Integer> punti){return puntoDiInteresseRepo.findAllById(punti);}

    public PuntoDiInteresse getPuntoByID(int id) {
        return puntoDiInteresseRepo.findById(id);
    }

    public void deletePunto(int id){
        puntoDiInteresseRepo.deleteById(id);
    }
    /*
    Metodo per la segnalazione di un punto di interesse: crea una copia del punto in questione, chiama il metodo segnala()
    con associato il motivo della segnalazione e reinserisce il nuovo punto di interesse segnalato sul db
     */
    public PuntoDiInteresse segnalaPunto(int id, String motivo) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.segnala(motivo);
        puntoDiInteresseRepo.save(temp);
        return temp;
    }

    public List<PuntoDiInteresse> getSegnalati() {
        return puntoDiInteresseRepo.allSegnalati();
    }

    /*
    Metodo per la rimozione della segnalazione con funzionamento analogo a segnalaPunto()
     */
    public PuntoDiInteresse removeSegnalato(int id) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.removeSegnalato();
        return puntoDiInteresseRepo.save(temp);
    }
}
