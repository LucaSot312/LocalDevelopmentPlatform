package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PuntoDiInteresseRepo extends MongoRepository<PuntoDiInteresse, java.lang.Integer> {

    @Query("{ 'id' : ?0 }")
    PuntoDiInteresse findById(int id);



}
