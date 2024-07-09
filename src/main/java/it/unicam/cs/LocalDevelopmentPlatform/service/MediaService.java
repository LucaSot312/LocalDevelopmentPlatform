package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.repository.MediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    private final MediaRepo mediaRepo;

    public MediaService(MediaRepo mediaRepo) {
        this.mediaRepo = mediaRepo;
    }

    public Media caricaMedia(Media media) {
       return mediaRepo.save(media);
    }

    public List<Media> visualizzaMedia(int idPunto) {
        return mediaRepo
                .findAll()
                .stream()
                .filter(data -> data.get_idPuntoDiInteresse()==idPunto)
                .toList();
    }
    public Media eliminaMedia(int idMedia){
        Optional<Media> daEliminare=mediaRepo.findById(idMedia);
        if(daEliminare.isPresent()){
            mediaRepo.deleteById(idMedia);
            return daEliminare.get();
        }
        return null;


    }
}
