package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.repository.ContestRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.MediaRepo;
import it.unicam.cs.LocalDevelopmentPlatform.repository.PuntoDiInteresseRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.*;

/*
Classe Service per l'implementazione delle funzionalità relative ai contest
messe a disposizione nel relativo Controller
 */
@Service
public class ContestService {
    private final ContestRepo contestRepo;
    private final UserService userService;
    private final PuntoDiInteresseRepo puntoDiInteresseRepo;
    private final MediaRepo mediaRepo;

    public ContestService(ContestRepo contestRepo, UserService userService, PuntoDiInteresseRepo puntoDiInteresseRepo, MediaRepo mediaRepo) {
        this.contestRepo = contestRepo;
        this.userService = userService;
        this.puntoDiInteresseRepo = puntoDiInteresseRepo;
        this.mediaRepo = mediaRepo;
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
    Aggiunge un nuovo partecipante ad un contest controllando che non sia già presente
     */
    public Contest aggiungiPartecipante(int idContest, int idPartecipante) {
        if (contestRepo.findById(idContest).getListaPartecipanti().contains(idPartecipante)) {
            return null;
        } else {
            Contest contest= contestRepo.findById(idContest);
            ArrayList<Integer> partecipanti=contest.getListaPartecipanti();
            partecipanti.add(idPartecipante);
            contest.setListaPartecipanti(partecipanti);
            contestRepo.deleteById(idContest);
            return contestRepo.save(contest);
        }
    }

    /*
    Determina il vincitore di un contest
    */
    public List<Integer> determinaVincitore(int idContest) {
        Contest contest= contestRepo.findById(idContest);
        List<Media> mediaContributions = mediaRepo.findBy_idPuntoDiInteresseInAnd_idContest(contest.getListaPunti(), contest.get_id());

        // Filtra i media in base alla data di caricamento e alla data di creazione e di fine di un contest
        mediaContributions = mediaContributions.stream()
                .filter(media -> media.get_dataCaricamento().after(contest.getDataInizio()) && media.get_dataCaricamento().before(contest.getDataFine()))
                .collect(Collectors.toList());

        // Raggruppa i media in base all'id dell'utente e conta ciascuna contribuzione
        Map<Integer, Long> contributorCounts = mediaContributions.stream()
                .collect(Collectors.groupingBy(Media::get_idUploader, Collectors.counting()));

        // Trova il massimo tra il numero delle contribuzioni
        long maxCount = contributorCounts.values().stream()
                .max(Long::compare)
                .orElse(0L);

        // Cerca gli utenti con il massimo numero di contribuzioni
        List<Integer> winnerContributorIds = contributorCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return winnerContributorIds;
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
