package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
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

    public BufferPunti savePunto(BufferPunti punto) {
        return bufferPuntiRepo.save(punto);

    }

    public List<BufferPunti> getAll() {
        return bufferPuntiRepo.findAll();
    }
    /*
    Metodo per la verifica di un punto di interesse: crea una copia del punto non verificato
    istanziandola con il tipo del punto verificato, inizializza i nuovi campi e la salva sul db
     */
    public void verificaPunto(int id) {
        BufferPunti temp = bufferPuntiRepo.findById(id).orElseThrow();
        PuntoDiInteresse punto = new PuntoDiInteresse(temp.getCoordinata(), temp.getNome(), temp.getTipologia(), temp.getDescrizione());
        puntoDiInteresseRepo.save(punto);
        bufferPuntiRepo.deleteById(id);
    }

    public void pulisciBuffer(int id) {
        bufferPuntiRepo.deleteById(id);
    }
}
