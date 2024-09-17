package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.State;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Verificato;
import it.unicam.cs.LocalDevelopmentPlatform.repository.BufferPuntiRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
/*
Classe Service per l'implementazione delle funzionalità relative ai punti di interesse
non verificati messe a disposizione nel Controller
 */
@Service
public class BufferPuntiService {

    private final BufferPuntiRepo bufferPuntiRepo;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    public BufferPuntiService(BufferPuntiRepo bufferPuntiRepo, PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.bufferPuntiRepo = bufferPuntiRepo;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }

    public State salvaPunto(State punto) {
        return bufferPuntiRepo.save(punto);

    }

    public List<State> getAll() {
        return bufferPuntiRepo.findAll();
    }
    /*
    Metodo per la verifica di un punto di interesse: crea una copia del punto non verificato
    istanziandola con il tipo del punto verificato, inizializza i nuovi campi e la salva sul db
     */
    public Verificato verificaPunto(int id) {
        State temp = bufferPuntiRepo.findById(id).orElseThrow();
        Verificato punto = new Verificato(temp.getCoordinata(), temp.getNome(), temp.getTipologia(), temp.getDescrizione());
        bufferPuntiRepo.deleteById(id);
        return puntoDiInteresseRepo.save(punto);
        //return puntoDiInteresseRepo.findById(id);
    }

    public boolean pulisciBuffer(int id) {
        bufferPuntiRepo.deleteById(id);
        return !bufferPuntiRepo.existsById(id);
    }
}
