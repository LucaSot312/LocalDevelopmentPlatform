package it.unicam.cs.LocalDevelopmentPlatform.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;

@Repository
public interface UserRepo extends MongoRepository<User,Integer> {

   @Query("{ '_id' : ?0}")
    User findById(int id);

   @Query("{ 'username' : ?0}")
    User findByUsername(String username);
}
