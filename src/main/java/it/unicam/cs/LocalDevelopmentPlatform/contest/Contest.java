package it.unicam.cs.LocalDevelopmentPlatform.contest;

import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;

public class Contest {

    @jakarta.persistence.Id
    private int Id;
    private int IdAnimatore;
    private Date dataInizio;
    private Date dataFine;
    private ArrayList<Integer> listaPunti;
    private ArrayList<Integer> listaPartecipanti;

    public Contest(Date dataFine, Date dataInizio,
                   ArrayList<Integer> listaPunti,ArrayList<Integer> listaPartecipanti) {
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
        this.listaPunti = listaPunti;
        this.listaPartecipanti = listaPartecipanti;
    }

    public void addPartecipanti(ArrayList<Integer> listaPartecipanti) {
        this.listaPartecipanti.addAll(listaPartecipanti);
    }

}
