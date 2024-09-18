package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ItinerarioRepo;

import java.util.ArrayList;
import java.util.List;
/*
Classe Service per l'implementazione delle funzionalità relative agli itinerari
messe a disposizione nel Controller
 */
@Service
public class ItinerarioService {
    private final ItinerarioRepo itinerarioRepo;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;    

    @Autowired
    public ItinerarioService(ItinerarioRepo itinerarioRepo, PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.itinerarioRepo = itinerarioRepo;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }
    /*
    Restituisce un itinerario dato dato l'id
     */
    public Itinerario getItinerarioById(int id){
        return itinerarioRepo.findById(id);
    }
    /*
    Restituisce tutti gli itinerari presenti nella mappa
     */
    public List<Itinerario> getAllItinerari(){
        return itinerarioRepo.findAll();
    }
    /*
    Crea un nuovo itinerario controllando che i punti che lo compongono almeno 2 e che esistano
     */
    public Itinerario caricaItinerario(Itinerario itinerario) {
        ArrayList<Integer> listaFiltrata = itinerario.getItinerario();
        listaFiltrata.removeIf(num -> puntoDiInteresseRepo.findById(num).isEmpty());
        itinerario.setItinerario(listaFiltrata);
        if(itinerario.getItinerario().isEmpty() || itinerario.getItinerario().size()==1){
            return null;
        }
        else{return itinerarioRepo.save(itinerario);}

    }
    /*
    Metodo per ottenere tutti i punti che compongono un itinerario: si ottiene prima l'itinerario tramite il suo id,
    successivamente si ottiene una lista degli id dei punti che lo compongono e infine per ogni elemento della lista
    si chiama il metodo findById() che ritorna il punto di interesse in questione
     */
    public List<PuntoDiInteresse> getPuntiItinerario(int id) {
            Itinerario itinerario = getItinerarioById(id);
            List<Integer> puntiIds = itinerario.getItinerario();
            List<PuntoDiInteresse> puntiDiInteresse = new ArrayList<>();
            for (Integer puntoId : puntiIds) {
                PuntoDiInteresse punto = puntoDiInteresseRepo.findById(puntoId)
                        .orElseThrow(() -> new RuntimeException("Punto di interesse not found"));
                puntiDiInteresse.add(punto);
            }
            return puntiDiInteresse;
        }
    /*
    Cancella un itinerario dato l'id
     */
    public boolean eliminaItinerario(int id) {
        puntoDiInteresseRepo.deleteById(id);
        return !puntoDiInteresseRepo.existsById(id);
    }
    /*
    Metodo utility che dato un id (punto di interesse) restituisce tutti gli itinerari (id) che contengono quel punto
      */
    public List<Integer> checkPunti(int id) {
        List<Integer> checklist = new ArrayList<>();
        for (Itinerario itinerario : itinerarioRepo.findAll()){
            if(itinerario.getItinerario().contains(id)){
                checklist.add(itinerario.getId());
            }
        }
        return checklist;
    }
}