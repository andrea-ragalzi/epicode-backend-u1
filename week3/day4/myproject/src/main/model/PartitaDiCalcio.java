package main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import main.enumerate.TipoEvento;

@Entity
@Table(name = "partite_di_calcio")
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.inStreaming")
public class PartitaDiCalcio extends Evento {

    @Column(name="squadra_di_casa", nullable = false)
    private String squadraDicasa;

    @Column(name="squadra_ospite", nullable = false)
    private String squadraOspite;

    @Column(name="squadra_vincente", nullable = false)
    private String squadraVincente;

    @Column(name="numero_gol_di_casa", nullable = false)
    private int numeroGolDiCasa;

    @Column(name="numero_gol_ospite", nullable = false)
    private int numeroGolOspite;

    public PartitaDiCalcio() {
        super();
    }

    public PartitaDiCalcio(LocalDate dataEvento, String descrizione,
            TipoEvento tipoEvento, Integer numeroMassimoPartecipanti,
            Location location,
            String squadraDicasa, String squadraOspite,
            int numeroGolDiCasa, int numeroGolOspite) {
        super(dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti,
                location);
        this.squadraDicasa = squadraDicasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolDiCasa = numeroGolDiCasa;
        this.numeroGolOspite = numeroGolOspite;
        if (this.numeroGolDiCasa > this.numeroGolOspite) {
            this.squadraVincente = this.squadraDicasa;
        } else if (this.numeroGolDiCasa < this.numeroGolOspite) {
            this.squadraVincente = this.squadraOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public PartitaDiCalcio(Long numeroEvento, LocalDate dataEvento, String descrizione,
            TipoEvento tipoEvento, Integer numeroMassimoPartecipanti,
            Location location,
            String squadraDicasa, String squadraOspite,
            int numeroGolDiCasa, int numeroGolOspite) {
        super(numeroEvento, dataEvento, descrizione, tipoEvento,
                numeroMassimoPartecipanti, location);
        this.squadraDicasa = squadraDicasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolDiCasa = numeroGolDiCasa;
        this.numeroGolOspite = numeroGolOspite;
        if (this.numeroGolDiCasa > this.numeroGolOspite) {
            this.squadraVincente = this.squadraDicasa;
        } else if (this.numeroGolDiCasa < this.numeroGolOspite) {
            this.squadraVincente = this.squadraOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public String getSquadraDicasa() {
        return squadraDicasa;
    }

    public void setSquadraDicasa(String squadraDicasa) {
        this.squadraDicasa = squadraDicasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolDiCasa() {
        return numeroGolDiCasa;
    }

    public void setNumeroGolDiCasa(int numeroGolDiCasa) {
        this.numeroGolDiCasa = numeroGolDiCasa;
    }

    public int getNumeroGolOspite() {
        return numeroGolOspite;
    }

    public void setNumeroGolOspite(int numeroGolOspite) {
        this.numeroGolOspite = numeroGolOspite;
    }
}
