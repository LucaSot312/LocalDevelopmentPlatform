package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;
import java.util.List;

/*
Classe che implementa l'animatore, con responsabilità di bandire un contest di contribuzione e determinarne il vincitore
 */
public class Animatore extends TuristaAutenticato {
    public Animatore(String username, String password, Ruolo ruolo) {
        super(username, password, ruolo);
    }


}
