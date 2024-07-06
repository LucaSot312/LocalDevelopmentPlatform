package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.repository.MediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
