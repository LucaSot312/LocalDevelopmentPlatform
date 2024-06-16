package it.unicam.cs.LocalDevelopmentPlatform.utenti;

import it.unicam.cs.LocalDevelopmentPlatform.contest.Contest;
import it.unicam.cs.LocalDevelopmentPlatform.luoghi.PuntoDiInteresse;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;
import java.util.List;

/*
Classe che implementa l'animatore, con responsabilità di bandire un contest di contribuzione e determinarne il vincitore
 */
public class Animatore extends User {
    public Animatore(String username, String password, Ruolo ruolo) {
        super(username, password, ruolo);
    }

        /*
        Il metodo va a creare un nuovo contest caratterizzato da una data di inizio, una di fine e la lista dei punti di interesse che partecipano al contest
         */
    public Contest bandisciContest(Date inizio, Date fine, List<PuntoDiInteresse> punti){

        return null;
    };
    public int determinaVincitore(){
        return 0;
    }

}
