package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContestRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Contest> getAllContests() {
        return contestRepo.findAll();
    }

    public Contest getContestById(int id) {
        return contestRepo.findById(id);
    }

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

    public User determinaVincitore(int Idcontest){
        //TODO il presente metodo va implementato dopo aver implementato login, sessione
        // e anche il database dei media per poter calcolare chi ha caricato e quanto abbia caricato
        // e determinare il vincitore
        return null;
    }
}
