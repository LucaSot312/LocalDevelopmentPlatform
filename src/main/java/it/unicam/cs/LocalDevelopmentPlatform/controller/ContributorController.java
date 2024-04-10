package it.unicam.cs.LocalDevelopmentPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.LocalDevelopmentPlatform.service.ContributorService;
import it.unicam.cs.LocalDevelopmentPlatform.utenti.Contributor;

@RestController
public class ContributorController {

    @Autowired
    private Contributor contributor;
    private final ContributorService contributorService;
    public ContributorController(Contributor contributor, ContributorService contributorService) {
        this.contributor=contributor;
        this.contributorService = contributorService;
    }
    
    // Add your request mapping methods here
}