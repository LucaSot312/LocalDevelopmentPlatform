package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContestRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Classe Service per l'implementazione delle funzionalità relative ai contest
messe a disposizione nel relativo Controller
 */
@Service
public class ContestService {
    private final ContestRepo contestRepo;
    private final UserRepo userRepo;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;
    private final UserService userService;
    private final PuntoDiInteresseService puntoDiInteresseService;

    public ContestService(ContestRepo contestRepo, UserRepo userRepo, PuntoDiInteresseRepo puntoDiInteresseRepo, UserService userService, PuntoDiInteresseService puntoDiInteresseService) {
        this.contestRepo = contestRepo;
        this.userRepo = userRepo;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
        this.userService = userService;
        this.puntoDiInteresseService = puntoDiInteresseService;
    }

    /*
    Restituisce un contest dato l'id
     */
    public Contest getContestById(int id) {
        return contestRepo.findById(id);
    }

    /*
    Metodo per la creazione di un nuovo contest
     */
    public Contest bandisciContest(Contest contest) {

        if (puntoDiInteresseService.filtraPuntiDiInteresse(contest.getListaPunti()).isEmpty()) {
            return null;
        } else {
            contest.setListaPunti(puntoDiInteresseService.filtraPuntiDiInteresse(contest.getListaPunti()));
            contest.setListaPartecipanti(userService.filtraUtenti(contest.getListaPartecipanti()));
            return contestRepo.save(contest);
        }
    }

    /*
    Metodo per l'aggiunta di nuovi partecipanti al contest
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
    Metodo per determinare il vincitore del contest
    */
    public User determinaVincitore(int Idcontest) {
        //TODO il presente metodo va implementato dopo aver implementato login, sessione
        // e anche il database dei media per poter calcolare chi ha caricato e quanto abbia caricato
        // e determinare il vincitoreA
        return null;
    }

    /*
    Metodo per ottenere tutti i contest attivi
    */
    public List<Contest> allContest() {
        return contestRepo.findAll();
    }

    /*
    Metodo per l'eliminazione di un contest dato l'id
    */
    public boolean eliminaContest(int id) {
        contestRepo.deleteById(id);
        return !contestRepo.existsById(id);
    }

    /*
    Metodo per il controllo dei punti di interesse sui quali è aperto un contest
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
    Metodo per restiruire tutti i contest ai quali un utente è iscritto
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
