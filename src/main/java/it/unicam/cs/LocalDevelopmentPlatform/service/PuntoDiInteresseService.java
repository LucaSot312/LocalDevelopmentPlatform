package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    public PuntoDiInteresseService(PuntoDiInteresseRepo puntoDiInteresseRepo, ItinerarioService itinerarioService, ContestService contestService) {
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
        this.itinerarioService = itinerarioService;
        this.contestService = contestService;
    }
    /*
    Restituisce tutti i punti di interesse presenti nella mappa
     */
    public List<PuntoDiInteresse> getAllPunti() {
        return puntoDiInteresseRepo.findAll();
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
    public PuntoDiInteresse segnalaPunto(int id, String motivo) {
        PuntoDiInteresse temp=puntoDiInteresseRepo.findById(id);
        puntoDiInteresseRepo.deleteById(id);
        temp.segnala(motivo);
        puntoDiInteresseRepo.save(temp);
        return temp;
    }
    /*
    Restituisce tutti i punti di interesse segnalati
     */
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
    /*
    Metodo utility che presa una lista di id di punti di interesse rimuove dalla lista i punti che non sono più presenti nella mappa
     */
    public ArrayList<Integer> filtraPuntiDiInteresse(ArrayList<Integer> listaPunti) {
        listaPunti.removeIf(num -> puntoDiInteresseRepo.findById(num).isEmpty());
        return listaPunti;
    }
}
