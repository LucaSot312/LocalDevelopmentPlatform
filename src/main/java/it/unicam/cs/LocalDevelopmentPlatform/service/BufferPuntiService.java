package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.BufferPunti;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.BufferPuntiRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BufferPuntiService {

    private final BufferPuntiRepo bufferPuntiRepo;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    public BufferPuntiService(BufferPuntiRepo bufferPuntiRepo, PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.bufferPuntiRepo = bufferPuntiRepo;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }

    public void savePunto(BufferPunti punto) {
        bufferPuntiRepo.save(punto);
    }

    public List<BufferPunti> getAll() {
        return bufferPuntiRepo.findAll();
    }

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
