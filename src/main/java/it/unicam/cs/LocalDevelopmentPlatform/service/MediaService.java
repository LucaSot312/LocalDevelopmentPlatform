package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import it.unicam.cs.LocalDevelopmentPlatform.repository.MediaRepo;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    private final MediaRepo mediaRepo;

    public MediaService(MediaRepo mediaRepo) {
        this.mediaRepo = mediaRepo;
    }

    public Media caricaMedia(Media media) {
       return mediaRepo.save(media);
    }
}
