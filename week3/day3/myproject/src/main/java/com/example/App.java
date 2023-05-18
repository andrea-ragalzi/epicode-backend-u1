package main.java.com.example;

import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import main.utils.JpaUtil;
import main.model.Evento;
import main.model.Location;
import main.model.Partecipazione;
import main.model.Persona;
import main.model.Sesso;
import main.model.Stato;
import main.model.TipoEvento;

public class App {
    static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        inserisciLocationCasuali(5);
        inserisciPersoneCasuali(30);
        inserisciEventiCasuali(10);
        inserisciPartecipazioniCasuali(20);
    }

    public static void inserisciLocationCasuali(int n) {
        String[] città = { "Roma", "Milano", "Napoli", "Torino", "Firenze", "Bologna", "Genova", "Venezia", "Verona",
                "Bari", "Palermo", "Cagliari", "Catania" };

        Random random = new Random();
        int i;
        for (i = 0; i < n; i++) {
            String nomeLocation = "Location " + (i + 1);
            String cittàCasuale = città[random.nextInt(città.length)];
            em.getTransaction().begin();
            em.persist(new Location(nomeLocation, cittàCasuale));
            em.getTransaction().commit();
        }
        System.out.println("Numero di locazioni inserite: " + i);
    }

    public static void inserisciPersoneCasuali(int n) {
        String[] nomi = { "Mario", "Luigi", "Giovanni", "Paolo", "Francesca", "Laura", "Simone", "Federico",
                "Alessandra",
                "Valentina", "Alice", "Lorenzo", "Gabriele", "Marta", "Giulia", "Davide", "Carlo", "Matteo", "Stefano",
                "Roberto", "Marco" };

        String[] cognomi = { "Rossi", "Bianchi", "Verdi", "Neri", "Russo", "Romano", "Ferrari", "Esposito", "Ricci",
                "Bruno", "Mancini", "Costa", "Greco", "Conti", "Gallo", "Lombardi", "Moretti", "Barbieri", "Fontana",
                "Santoro", "Marino" };

        Random random = new Random();

        int i = 0;
        for (i = 0; i < n; i++) {
            String nomeCasuale = nomi[random.nextInt(nomi.length)];
            String cognomeCasuale = cognomi[random.nextInt(cognomi.length)];
            String emailCasuale = nomeCasuale.toLowerCase() + "." + cognomeCasuale.toLowerCase() + "@example.com";
            LocalDate dataNascitaCasuale = LocalDate.of(random.nextInt(50) + 1950, random.nextInt(12) + 1,
                    random.nextInt(28) + 1);
                    Sesso sesso = Sesso.values()[random.nextInt(Sesso.values().length)];
            Persona persona = new Persona(nomeCasuale, cognomeCasuale, emailCasuale, dataNascitaCasuale, sesso);
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        }
        System.out.println("Numero di persone inserite: " + i);
    }

    public static void inserisciEventiCasuali(int n) {
        String[] descrizioni = { "Festa di compleanno", "Conferenza", "Concerto", "Cena di gala", "Incontro di lavoro",
                "Festa di laurea", "Festa di matrimonio", "Festa di Natale", "Festa di Capodanno", "Festa di Halloween",
                "Festa del papà", "Festa della mamma" };

        Random random = new Random();

        List<Location> locations = em.createQuery("SELECT l FROM Location l", Location.class).getResultList();

        for (int i = 0; i < n; i++) {
            LocalDate dataCasuale = LocalDate.now().plusDays(random.nextInt(365));
            String descrizioneCasuale = descrizioni[random.nextInt(descrizioni.length)];
            TipoEvento tipoEventoCasuale = TipoEvento.values()[random.nextInt(TipoEvento.values().length)];
            Integer numeroMassimoPartecipantiCasuale = random.nextInt(100);
            Location locationCasuale = locations.get(random.nextInt(locations.size()));
            Evento evento = new Evento(dataCasuale, descrizioneCasuale, tipoEventoCasuale,
                    numeroMassimoPartecipantiCasuale);
            evento.setLocation(locationCasuale);
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
            System.out.println(evento.toString() + " salvato nel DB!!");
        }
    }

    public static void inserisciPartecipazioniCasuali(int n) {
        List<Evento> eventi = em.createQuery("SELECT e FROM Evento e", Evento.class).getResultList();
        List<Persona> persone = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Persona personaCasuale = persone.get(random.nextInt(persone.size()));
            Evento eventoCasuale = eventi.get(random.nextInt(eventi.size()));
            Partecipazione partecipazione = new Partecipazione(personaCasuale, eventoCasuale,
                    Stato.DA_CONFERMARE);
            em.getTransaction().begin();
            em.persist(partecipazione);
            em.getTransaction().commit();
            System.out.println(partecipazione.toString() + " salvata nel DB!!");
        }
    }

}
