package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContestRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContestService {
    private final ContestRepo contestRepo;

    public ContestService(ContestRepo contestRepo) {
        this.contestRepo = contestRepo;
    }

    public List<Contest> getAllContests() {
        return contestRepo.findAll();
    }

    public Contest getItinerarioById(int id) {
        return contestRepo.findById(id);
    }

    public void addPartecipante(int idContest, ArrayList<Integer> listaPartecipanti) {
        Contest temp = getItinerarioById(idContest);
        temp.addPartecipanti(listaPartecipanti);
        contestRepo.deleteById(idContest);
        contestRepo.save(temp);
    }

    //TODO metodo bandisci contest
}
