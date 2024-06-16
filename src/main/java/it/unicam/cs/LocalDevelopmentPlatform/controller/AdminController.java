package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.service.UserService;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    Classe controller per la gestione del profilo Admin
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }
    /*
    Aggiunta di un nuovo utente
     */
    @PostMapping("/caricaUtente")
    public User caricaUtente(@RequestBody User user) {return userService.addUser(user);}
    /*
    Visualizzazione di tutti gli utenti registrati
     */
    @GetMapping("/utenti")
    public List<User> utenti() {return userService.findAll();}
    /*
    Ricerca degli utenti tramite username
     */
    @GetMapping("/usrnUtente/{username}")
    public User usrnUtente(@PathVariable String username) {return userService.loadUserByUsername(username);}
    /*
    Ricerca tramite id
     */
    @GetMapping("/utente/{id}")
    public User utente(@PathVariable int id) {return userService.findUserById(id);}
    /*
    Eliminazione di un utente tramite id
     */
    @PutMapping("/eliminaUtente/{id}")
    public void eliminaUtente(@PathVariable int id) {userService.deleteUserById(id);}
}
