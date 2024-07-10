package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepo extends MongoRepository<Media, Integer> {
    @Query("{ idPuntoDiInteresse: { $in: ?0 }, idContest: ?1 }")
    List<Media> findBy_idPuntoDiInteresseInAnd_idContest(List<Integer> puntoDiInteresseIds, int contestId);

}
