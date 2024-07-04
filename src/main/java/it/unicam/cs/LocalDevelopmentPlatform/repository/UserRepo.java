package it.unicam.cs.LocalDevelopmentPlatform.repository;

import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Classe Repository per la gestione degli utenti
 */
@Repository
public interface UserRepo extends MongoRepository<User, Integer> {
    /*
    Ottieni un utente tramite id
     */
    @Query("{'_id' :  ?0}")
    User findById(int id);
    /*
    Ottieni un utente tramite username
     */
    @Query("{'username' :  ?0}")
    User findByUsername(String username);
    /*
    Ottieni tutti gli utenti che non sono Admin
     */
    @Query("{'ruolo' :{ $ne : 'ADMIN' } } ")
    List<User> findAllNotAdmin();
}

