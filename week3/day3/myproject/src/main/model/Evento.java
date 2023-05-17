package main.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @SequenceGenerator(name = "evento_generator", sequenceName = "evento_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_generator")
    @Column(name = "numero_evento", unique = true, nullable = false)
    private Long numeroEvento;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "descrizione", nullable = true)
    private String descrizione;

    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti", nullable = true)
    private Integer numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("persona ASC")
    private Set<Partecipazione> partecipazioni;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    public Evento() {
    }

    public Evento(LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Integer numeroMassimoPartecipanti) {
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento(Long numeroEvento, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
            Integer numeroMassimoPartecipanti) {
        this.numeroEvento = numeroEvento;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    // Getter methods
    public Long getNumeroEvento() {
        return numeroEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    // Setter methods
    public void setNumeroEvento(Long numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Set<Partecipazione> getPartecipazioni() {
        return this.partecipazioni;
    }

    public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // toString method
    @Override
    public String toString() {
        return "Evento [numeroEvento=" + numeroEvento + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
                + ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
    }
}
