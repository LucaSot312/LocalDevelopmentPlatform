package it.unicam.cs.LocalDevelopmentPlatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;

@Repository
public interface ItinerarioRepo extends MongoRepository<Itinerario, Integer>{
    @Query("{ '_id' : ?0 }")
    Itinerario findById(int id);
}