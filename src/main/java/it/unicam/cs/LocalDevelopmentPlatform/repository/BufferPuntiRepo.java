package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.State;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/*
Classe Repository per la gestione dei punti di interesse non ancora verificati
 */
@Repository
public interface BufferPuntiRepo extends MongoRepository<State, java.lang.Integer> {

}
