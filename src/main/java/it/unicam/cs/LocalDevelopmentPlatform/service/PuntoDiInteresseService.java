package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
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
    public PuntoDiInteresseService(PuntoDiInteresseRepo puntoDiInteresseRepo, ItinerarioService itinerarioService, ContestService contestService, MediaService mediaService) {
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
        this.itinerarioService = itinerarioService;
        this.contestService = contestService;
        this.mediaService = mediaService;
    }
    /*
    Restituisce tutti i punti di interesse presenti nella mappa
     */
    public List<Verificato> getAllPunti() {
        return puntoDiInteresseRepo.findAll();
    }
    /*
    Restituisce un punto di interesse dato il suo id
     */
    public Verificato getPuntoById(int id) {
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
    Metodo per la segnalazione di un punto di interesse: crea una copia del punto in questione, chiama il metodo segnala()
    con associato il motivo della segnalazione e reinserisce il nuovo punto di interesse segnalato sul db
     */
    public Verificato segnalaPunto(int id, String motivo) {
        Verificato temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.segnala(motivo);
        puntoDiInteresseRepo.save(temp);
        return temp;
    }
    /*
    Restituisce tutti i punti di interesse segnalati
     */
    public List<Verificato> getSegnalati() {
        return puntoDiInteresseRepo.allSegnalati();
    }

    /*
    Metodo per la rimozione della segnalazione con funzionamento analogo a segnalaPunto()
     */
    public Verificato removeSegnalato(int id) {
        Verificato temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.removeSegnalato();
        return puntoDiInteresseRepo.save(temp);
    }
}
