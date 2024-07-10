package it.unicam.cs.LocalDevelopmentPlatform.contest;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "media")
public class Media {

    @Id
    private int _id;

    private String descrizione;

    private Formato formato;

    private String payload;

    private int _idUploader;

    private int _idPuntoDiInteresse;

    private Date _dataCaricamento;

    public Media(String descrizione, Formato formato, int _idUploader,
                 int _idPuntoDiInteresse, String payload) {
        this.descrizione = descrizione;
        this.formato = formato;
        this._idUploader = _idUploader;
        this._idPuntoDiInteresse = _idPuntoDiInteresse;
        this._dataCaricamento = new Date();
        this.payload = payload;
        this._id = this.hashCode();
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int get_idUploader() {
        return _idUploader;
    }

    public void set_idUploader(int _idUploader) {
        this._idUploader = _idUploader;
    }

    public int get_idPuntoDiInteresse() {
        return _idPuntoDiInteresse;
    }

    public void set_idPuntoDiInteresse(int _idPuntoDiInteresse) {
        this._idPuntoDiInteresse = _idPuntoDiInteresse;
    }

    public Date get_dataCaricamento() {
        return _dataCaricamento;
    }

    public void set_dataCaricamento(Date _dataCaricamento) {
        this._dataCaricamento = _dataCaricamento;
    }

    @Override
    public String toString() {
        return "Media{" +
                "_id=" + _id +
                ", _idUploader=" + _idUploader +
                ", _idPuntoDiInteresse=" + _idPuntoDiInteresse +
                ", _dataCaricamento=" + _dataCaricamento +
                '}';
    }
}
