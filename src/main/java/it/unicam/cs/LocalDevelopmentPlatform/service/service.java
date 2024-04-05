package it.unicam.cs.LocalDevelopmentPlatform.service;

import it.unicam.cs.LocalDevelopmentPlatform.luoghi.Itinerario;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;

import java.util.List;

public interface service {
    List<PuntoDiInteresse> getAllPunti();

    PuntoDiInteresse getPuntoByID(int id);

    List<Itinerario> getAllItinerari();
    Itinerario getItinerarioByID(int id);
}
