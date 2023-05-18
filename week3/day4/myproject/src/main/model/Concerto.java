package main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import main.enumerate.Genere;
import main.enumerate.TipoEvento;

@Entity
@Table(name = "concerti")
@NamedQuery(name = "concertiInStreaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query = "SELECT c FROM Concerto c WHERE c.genere IN :listaGenere")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genere genere;

    @Column(name="in_streaming", nullable = false)
    private boolean inStreaming;

    public Concerto() {
        super();
    }

    public Concerto(LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
            Integer numeroMassimoPartecipanti, Location location,
            Genere genere, boolean inStreaming) {
        super(dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto(Long numeroEvento, LocalDate dataEvento, String descrizione,
            TipoEvento tipoEvento, Integer numeroMassimoPartecipanti, Location location,
            Genere genere, boolean inStreaming) {
        super(numeroEvento, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return String.format("Concerto [numeroEvento=%d, dataEvento=%s, descrizione=%s, tipoEvento=%s, " +
                "numeroMassimoPartecipanti=%d, location=%s, genere=%s, inStreaming=%b]",
                super.getNumeroEvento(), super.getDataEvento(), super.getDescrizione(),
                super.getTipoEvento(), super.getNumeroMassimoPartecipanti(), super.getLocation(),
                this.genere, this.inStreaming);
    }
}
