package it.unicam.cs.LocalDevelopmentPlatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

public interface ContributorRepoPDI extends MongoRepository<PuntoDiInteresse,Integer> {

}
