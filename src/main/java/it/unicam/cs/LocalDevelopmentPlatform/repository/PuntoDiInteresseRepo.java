package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PuntoDiInteresseRepo extends MongoRepository<PuntoDiInteresse, java.lang.Integer> {

    @Query("{ 'id' : ?0 }")
    PuntoDiInteresse findById(int id);

    @Query("{verificato : true}")
    @Override
    List<PuntoDiInteresse> findAll();

    @Query("{verificato : false}")
    List<PuntoDiInteresse> findAllFalse();




}
