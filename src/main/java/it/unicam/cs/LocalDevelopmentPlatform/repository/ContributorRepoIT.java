package it.unicam.cs.LocalDevelopmentPlatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;

@Service
public interface ContributorRepoIT extends MongoRepository<Itinerario, Integer>{
    
}