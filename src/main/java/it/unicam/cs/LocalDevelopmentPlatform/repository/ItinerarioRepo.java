package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;

@Service
public interface ItinerarioRepo extends MongoRepository<Itinerario, Integer>{
    @Query("{ 'id' : ?0 }")
    Itinerario findById(int id);
}