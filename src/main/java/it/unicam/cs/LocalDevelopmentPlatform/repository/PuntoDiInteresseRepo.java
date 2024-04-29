package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntoDiInteresseRepo extends MongoRepository<PuntoDiInteresse, java.lang.Integer> {

    @Query("{ '_id' : ?0 }")
    PuntoDiInteresse findById(int id);

    @Query("{segnalato : true}")
    List<PuntoDiInteresse> allSegnalati();

}
