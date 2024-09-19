package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestRepo extends MongoRepository<Contest, Integer> {

    @Query("{'_id' : ?0}")
    Contest findById(int id);

}
