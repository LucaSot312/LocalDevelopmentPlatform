package it.unicam.cs.LocalDevelopmentPlatform.controller;

import it.unicam.cs.LocalDevelopmentPlatform.service.*;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.Ruolo;
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

    protected final UserService userService;

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
    public User findByUsername(@PathVariable String username) {return userService.findByUsername(username);}
    /*
    Ricerca tramite id
     */
    @GetMapping("/utente/{id}")
    public User findById(@PathVariable int id) {return userService.findById(id);}
    /*
    Eliminazione di un utente tramite id
     */
    @PutMapping("/eliminaUtente/{id}")
    public boolean eliminaUtente(@PathVariable int id) {return userService.eliminaUtente(id);}

    @PutMapping("/cambiaRuolo/{id}/{ruolo}")
    public User cambiaRuolo(@PathVariable int id, @PathVariable Ruolo ruolo) {return userService.cambiaRuolo(id,ruolo);}

}