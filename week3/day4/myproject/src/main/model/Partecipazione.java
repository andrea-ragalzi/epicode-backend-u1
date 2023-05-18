package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import main.enumerate.Stato;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @SequenceGenerator(name = "partecipazione_generator", sequenceName = "partecipazione_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partecipazione_generator")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Persona persona;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato = Stato.DA_CONFERMARE;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    // getter and setter methods

}
