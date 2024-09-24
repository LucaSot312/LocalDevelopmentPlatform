package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
Classe Repository per la gestione dei punti di interesse verificati
 */
@Repository
public interface PuntoDiInteresseRepo extends MongoRepository<PuntoDiInteresse, java.lang.Integer> {
    /*
    Ottieni i punti di interesse tramite id
     */
    @Query("{ '_id' : ?0 }")
    PuntoDiInteresse findById(int id);
    /*
    Ottieni tutti i punti di interesse segnalati
     */
    @Query("{'stato.segnalato' : true}")
    List<PuntoDiInteresse> puntiSegnalati();

}
