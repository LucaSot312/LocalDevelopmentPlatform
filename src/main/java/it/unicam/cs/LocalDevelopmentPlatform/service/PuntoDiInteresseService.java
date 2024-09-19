package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.NonVerificato;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Verificato;
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
    private final ItinerarioService itinerarioService;
    private final ContestService contestService;
    private final MediaService mediaService;

    @Autowired
    public PuntoDiInteresseService(PuntoDiInteresseRepo puntoDiInteresseRepo,
                                   ItinerarioService itinerarioService,
                                   ContestService contestService,
                                   MediaService mediaService)
    {
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
        this.itinerarioService = itinerarioService;
        this.contestService = contestService;
        this.mediaService = mediaService;
    }

  public PuntoDiInteresse salvaPunto(PuntoDiInteresse puntoDiInteresse)
  {
      if(puntoDiInteresse.getStato() instanceof Verificato){ return null; }
      return puntoDiInteresseRepo.save(puntoDiInteresse);
  }
    /*
    Restituisce tutti i punti di interesse presenti
     */
    public List<PuntoDiInteresse> getAllPuntiVerificati() {
        return puntoDiInteresseRepo
                .findAll()
                .stream()
                .filter(p -> p.getStato() instanceof Verificato)
                .toList();
    }

    /*
    Restituisce tutti i punti di interesse non verificati
    */
    public List<PuntoDiInteresse> getAllPuntiNonVerificati() {
        return puntoDiInteresseRepo
                .findAll()
                .stream()
                .filter(p -> p.getStato() instanceof NonVerificato)
                .toList();
    }

    /*
    Restituisce un punto di interesse dato il suo id
     */
    public PuntoDiInteresse getPuntoById(int id) {
        return puntoDiInteresseRepo.findById(id);
    }

    /*
    Cancella un punto di interesse dalla mappa dato il suo id, controllando se è presente o meno all'interno di itinerari e/o contest
     */
    public String deletePunto(int id){

        if(itinerarioService.checkPunti(id).isEmpty() && contestService.checkPunti(id).isEmpty()) {
            for(Media media : mediaService.visualizzaMedia(id))
            {
                mediaService.eliminaMedia(media.get_id());
            }
            puntoDiInteresseRepo.deleteById(id);
            return "Cancellazione andata a buon fine";
        }
        else{
            return "Cancellazione Fallita, Punto presente nei seguenti itinerari: "
                    .concat(itinerarioService.checkPunti(id).toString())
                    .concat("e nei seguenti contest: ")
                    .concat(contestService.checkPunti(id).toString());
        }
    }
    /*
    Metodo per la segnalazione di un punto di interesse: crea una copia del punto in questione,
    chiama il metodo segnala() con associato il motivo della segnalazione e reinserisce il nuovo
    punto di interesse segnalato sul db
     */
    public PuntoDiInteresse segnalaPunto(int id, String motivo) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        if(temp.getStato() instanceof Verificato){
            ((Verificato) temp.getStato()).segnala(motivo);
            return puntoDiInteresseRepo.save(temp);
        }
        return null;
    }

    /*
    Restituisce tutti i punti di interesse segnalati
     */
    public List<PuntoDiInteresse> getSegnalati() {
        return puntoDiInteresseRepo.puntiSegnalati();
    }

    /*
    Metodo per la rimozione della segnalazione con funzionamento analogo a segnalaPunto()
     */
    public PuntoDiInteresse removeSegnalato(int id) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        if(temp.getStato() instanceof Verificato){
            ((Verificato) temp.getStato()).removeSegnalato();
            return puntoDiInteresseRepo.save(temp);
        }
        return null;
    }

    public PuntoDiInteresse verificaPunto(int id) {
        return puntoDiInteresseRepo.findById(id).verifica();
    }
}
