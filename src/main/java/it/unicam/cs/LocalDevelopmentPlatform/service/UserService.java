package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{


    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User loadUserByUsername(String username) { return userRepo.findByUsername(username); }

    public User findUserById(int id) { return userRepo.findById(id); }

    public void deleteUserById(int id) { userRepo.deleteById(id); }

    public User addUser(User user) {return userRepo.save(user);}

    public List<User> findAll() {return userRepo.findAll(); }
}
