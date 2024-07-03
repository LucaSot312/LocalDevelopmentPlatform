package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContestRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
Classe Service per l'implementazione delle funzionalità relative ai contest
messe a disposizione nel relativo Controller
 */
@Service
public class ContestService {
    private final ContestRepo contestRepo;
    private final UserRepo userRepo;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;

    public ContestService(ContestRepo contestRepo, UserRepo userRepo, PuntoDiInteresseRepo puntoDiInteresseRepo) {
        this.contestRepo = contestRepo;
        this.userRepo = userRepo;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
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
    public Contest bandisciContest(Contest contest){
        ArrayList<Integer> listaFiltrUser = contest.getListaPartecipanti();
        ArrayList<Integer> listaFiltrPunti = contest.getListaPunti();
        listaFiltrUser.removeIf(num -> userRepo.findById(num).isEmpty());
        listaFiltrPunti.removeIf(num -> puntoDiInteresseRepo.findById(num).isEmpty());
        contest.setListaPartecipanti(listaFiltrUser);
        contest.setListaPunti(listaFiltrPunti);
        if(contest.getListaPunti().isEmpty()){
            return null;
        }
        else{
            return contestRepo.save(contest);
        }
    }
/*
Metodo per l'aggiunta di nuovi partecipanti al contest
 */
    public Contest aggiungiPartecipanti(int idContest, ArrayList<Integer> listaPartecipanti) {
        listaPartecipanti.removeIf(num -> userRepo.findById(num).isEmpty());
        if(listaPartecipanti.isEmpty()){
            return null;
        }
        else{
            Contest temp = getContestById(idContest);
            temp.addPartecipanti(listaPartecipanti);
            contestRepo.deleteById(idContest);
            contestRepo.save(temp);
            return temp;
        }
    }
/*
Metodo per determinare il vincitore del contest
 */
    public User determinaVincitore(int Idcontest){
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
    public boolean delContest(int id) {
        contestRepo.deleteById(id);
        if(contestRepo.existsById(id)){
            return false;
        }
        else{return true;}
    }

    public List<Integer> checkPunti(int id){
        List<Integer> checklist = new ArrayList();
        for(Contest contest : contestRepo.findAll()){
            if(contest.getListaPunti().contains(id)){
                checklist.add(contest.get_id());
            }
        }
        return checklist;
    }
}
