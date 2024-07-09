package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContestRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Classe Service per l'implementazione delle funzionalità relative ai contest
messe a disposizione nel relativo Controller
 */
@Service
public class ContestService {
    private final ContestRepo contestRepo;
    private final UserService userService;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    public ContestService(ContestRepo contestRepo, UserService userService, PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.contestRepo = contestRepo;
        this.userService = userService;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
    }

    /*
    Restituisce un contest dato l'id
     */
    public Contest getContestById(int id) {
        return contestRepo.findById(id);
    }

    /*
    Crea un nuovo contest
     */
    public Contest bandisciContest(Contest contest) { return contestRepo.save(contest); }

    /*
    Aggiunge nuovi partecipanti ad un contest controllando che non siano già presenti
     */
    public Contest aggiungiPartecipanti(int idContest, ArrayList<Integer> listaPartecipanti) {
        userService.filtraUtenti(listaPartecipanti);
        if (userService.filtraUtenti(listaPartecipanti).isEmpty()) {
            return null;
        } else {
            List<Integer> partecipantiVecchi = getContestById(idContest).getListaPartecipanti();
            ArrayList<Integer> partecipantiNuovi = userService.filtraUtenti(listaPartecipanti);
            ArrayList<Integer> partecipantiFinali = new ArrayList<>();
            partecipantiFinali.addAll(partecipantiVecchi);
            partecipantiFinali.addAll(partecipantiNuovi);
            Set<Integer> uniqueSet=new HashSet<>(partecipantiFinali);
            partecipantiFinali.clear();
            partecipantiFinali.addAll(uniqueSet);
            
            Contest contest= contestRepo.findById(idContest);
            contest.setListaPartecipanti(partecipantiFinali);
            contestRepo.deleteById(idContest);
            contestRepo.save(contest);
            return contest;
        }
    }

    /*
    Determina il vincitore di un contest
    */
    public List<User> determinaVincitore(int Idcontest) {
        // una volta ottenute le liste di punti e partecipanti dall oggetto contest del quale voglio sapere il vincitore
        // dopo aver ottenuto i media dalla repo filtro per le date di inizio e fine contest, per i punti sui quali si svolge
        // e sui partecipanti che contribuiscono raggruppando e contando secondo i loro id, infine ritorno un hashmap che ad ogni
        // idUtente associa il numero di contribuzioni
        return null;
    }

    /*
    Restituisce tutti i contest attivi
    */
    public List<Contest> allContest() {
        return contestRepo.findAll();
    }

    /*
    Elimina un contest dato l'id
    */
    public boolean eliminaContest(int id) {
        contestRepo.deleteById(id);
        return !contestRepo.existsById(id);
    }

    /*
    Controlla i punti di interesse sui quali è aperto un contest
    */
    public List<Integer> checkPunti(int id) {
        List<Integer> checklist = new ArrayList<>();
        for (Contest contest : contestRepo.findAll()) {
            if (contest.getListaPunti().contains(id)) {
                checklist.add(contest.get_id());
            }
        }
        return checklist;
    }

    /*
    Restituisce  tutti i contest ai quali un utente è iscritto
     */
    public List<Contest> mieiContest(int idUtente) {
        ArrayList<Contest> mieiContest = new ArrayList<>();
        for (Contest contest : contestRepo.findAll()) {
            if (contest.getListaPartecipanti().contains(idUtente)) {
                mieiContest.add(contest);
            }
        }
        return mieiContest;
    }
}
