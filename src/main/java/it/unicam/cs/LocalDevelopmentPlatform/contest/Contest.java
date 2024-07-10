package it.unicam.cs.LocalDevelopmentPlatform.contest;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Document(collection="contest")
/*
Entity class per rappresentare un oggetto Contest.
 */
public class Contest {

    @Id
    private int _id;
    /*
    Id dell'animatore che crea il contest
     */
    private int idAnimatore;
    /*
    Data di inizio del contest
     */
    private Date dataInizio;

    /*
    Data di conclusione del contest
     */
    private Date dataFine;
    /*
    Lista dei punti di interesse che partecipano al contest
     */
    private ArrayList<Integer> listaPunti;
    /*
    Lista dei partecipanti al contest
     */
    private ArrayList<Integer> listaPartecipanti;

    public Contest(Date dataFine, Date dataInizio,
                   ArrayList<Integer> listaPunti,ArrayList<Integer> listaPartecipanti, int idAnimatore){
        this.idAnimatore = idAnimatore;
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
        this.listaPunti = listaPunti;
        this.listaPartecipanti = listaPartecipanti;
        this._id =Math.abs(this.hashCode());
    }

    public ArrayList<Integer> getListaPartecipanti() {return listaPartecipanti;}

    public void setListaPartecipanti(ArrayList<Integer> listaPartecipanti) {
        this.listaPartecipanti = listaPartecipanti;
    }

    public ArrayList<Integer> getListaPunti() {
        return listaPunti;
    }

    public void setListaPunti(ArrayList<Integer> listaPunti) {
        this.listaPunti = listaPunti;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIdAnimatore() {
        return idAnimatore;
    }

    public void setIdAnimatore(int idAnimatore) {
        this.idAnimatore = idAnimatore;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contest contest)) return false;
        return _id == contest._id && idAnimatore == contest.idAnimatore && Objects.equals(dataInizio, contest.dataInizio) && Objects.equals(dataFine, contest.dataFine) && Objects.equals(getListaPunti(), contest.getListaPunti()) && Objects.equals(getListaPartecipanti(), contest.getListaPartecipanti());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimatore, dataInizio, dataFine, getListaPunti());
    }
}
