package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.repository.UserRepo;
import it.unicam.cs.LocalDevelopmentPlatform.service.UserService;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
    }

    @PostMapping("/caricaUtente")
    public User caricaUtente(@RequestBody User user) {return userService.addUser(user);}

    @GetMapping("/utenti")
    public List<User> utenti() {return userService.findAll();}

    @GetMapping("/usrnUtente/{username}")
    public User usrnUtente(@PathVariable String username) {return userService.loadUserByUsername(username);}

    @GetMapping("/utente/{id}")
    public User utente(@PathVariable int id) {return userService.findUserById(id);}

    @PutMapping("/eliminaUtente/{id}")
    public void eliminaUtente(@PathVariable int id) {userService.deleteUserById(id);}
}
