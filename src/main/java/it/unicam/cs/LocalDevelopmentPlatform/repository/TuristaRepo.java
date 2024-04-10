package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TuristaRepo extends MongoRepository<PuntoDiInteresse, Integer> {
    PuntoDiInteresse findByNome(String nome);
    

}
