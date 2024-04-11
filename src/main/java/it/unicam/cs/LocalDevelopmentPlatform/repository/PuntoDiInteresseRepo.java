package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PuntoDiInteresseRepo extends MongoRepository<PuntoDiInteresse, Integer> {
/*
    @Query(fields="{'coordinata' : 1, 'tipologia' : 1, 'descrizione': 1}")
    List<PuntoDiInteresse> findAll();
*/
}
