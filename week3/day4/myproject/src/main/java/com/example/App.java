package main.java.com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.utils.ConcertoDAO;
import main.utils.GenericDAO;
import main.model.Concerto;
import main.model.Evento;
import main.model.Location;
import main.model.Partecipazione;
import main.model.PartitaDiCalcio;
import main.model.Persona;
import main.enumerate.Genere;
import main.enumerate.Sesso;
import main.enumerate.Stato;
import main.enumerate.TipoEvento;

public class App {

    public static void main(String[] args) {
        inserisciLocationCasuali(5);
        inserisciPersoneCasuali(20);
        inserisciEventiCasuali(10);
        inserisciConcertiCasuali(5);
        inserisciPartecipazioniCasuali(20);
        /*
         * ConcertoDAO concertoDAO = new ConcertoDAO();
         * 
         * concertoDAO.getConcertiInStreaming(true).forEach(
         * System.out::println);
         * concertoDAO.getConcertiPerGenere(
         * List.of(Genere.CLASSICO, Genere.ROCK)).forEach(
         * System.out::println);
         */
    }

    public static void inserisciLocationCasuali(int n) {
        GenericDAO<Location> locationDAO = new GenericDAO<Location>(Location.class);
        String[] città = { "Roma", "Milano", "Napoli", "Torino", "Firenze", "Bologna", "Genova", "Venezia", "Verona",
                "Bari", "Palermo", "Cagliari", "Catania" };

        Random random = new Random();
        int i;
        for (i = 0; i < n; i++) {
            String nomeLocation = "Location " + (i + 1);
            String cittaLocation = città[random.nextInt(città.length)];
            locationDAO.save(new Location(nomeLocation, cittaLocation));
        }
        System.out.println("Numero di locazioni inserite: " + i);
    }

    public static void inserisciPersoneCasuali(int n) {
        GenericDAO<Persona> personaDAO = new GenericDAO<Persona>(Persona.class);
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
            personaDAO.save(persona);
        }
        System.out.println("Numero di persone inserite: " + i);
    }

    public static void inserisciEventiCasuali(int n) {
        GenericDAO<Evento> eventoDAO = new GenericDAO<Evento>(Evento.class);
        GenericDAO<Location> locationDAO = new GenericDAO<Location>(Location.class);
        String[] descrizioni = { "Festa di compleanno", "Conferenza", "Concerto", "Cena di gala", "Incontro di lavoro",
                "Festa di laurea", "Festa di matrimonio", "Festa di Natale", "Festa di Capodanno", "Festa di Halloween",
                "Festa del papà", "Festa della mamma" };

        Random random = new Random();

        List<Location> locations = new ArrayList<Location>();
        locations = locationDAO.getAll();

        int i;
        for (i = 0; i < n; i++) {
            LocalDate dataCasuale = LocalDate.now().plusDays(random.nextInt(365));
            String descrizioneCasuale = descrizioni[random.nextInt(descrizioni.length)];
            TipoEvento tipoEventoCasuale = TipoEvento.values()[random.nextInt(TipoEvento.values().length)];
            Integer numeroMassimoPartecipantiCasuale = random.nextInt(10000);
            Location locationCasuale = locations.get(random.nextInt(locations.size()));
            Evento evento = new Evento(dataCasuale, descrizioneCasuale, tipoEventoCasuale,
                    numeroMassimoPartecipantiCasuale, locationCasuale);
            eventoDAO.save(evento);
        }
        System.out.println("Numero di eventi inseriti: " + i);
    }

    public static void inserisciPartecipazioniCasuali(int n) {
        GenericDAO<Partecipazione> partecipazioneDAO = new GenericDAO<Partecipazione>(Partecipazione.class);
        GenericDAO<Persona> personaDAO = new GenericDAO<Persona>(Persona.class);
        GenericDAO<Evento> eventoDAO = new GenericDAO<Evento>(Evento.class);
        List<Evento> eventi = eventoDAO.getAll();
        List<Persona> persone = personaDAO.getAll();

        Random random = new Random();

        int i;
        for (i = 0; i < n; i++) {
            Persona personaCasuale = persone.get(random.nextInt(persone.size()));
            Evento eventoCasuale = eventi.get(random.nextInt(eventi.size()));
            Partecipazione partecipazione = new Partecipazione(
                    personaCasuale, eventoCasuale,
                    i % 2 == 0 ? Stato.CONFERMATA : Stato.DA_CONFERMARE);
            partecipazioneDAO.save(partecipazione);
        }
        System.out.println("Numero di partecipazioni inserite: " + i);
    }

    public static void inserisciPartiteDiCalcioCasuali(int n) {
        GenericDAO<PartitaDiCalcio> partitaDiCalcioDAO = new GenericDAO<PartitaDiCalcio>(PartitaDiCalcio.class);
        GenericDAO<Location> locationDAO = new GenericDAO<Location>(Location.class);
        String[] squadreSerieA = { "Atalanta", "Bari", "Cagliari", "Cremonese", "Foggia", "Genoa", "Inter", "Juventus",
                "Lazio", "Milan", "Napoli", "Padova", "Parma", "Pescara", "Roma", "Sampdoria", "Torino", "Vicenza" };

        Random random = new Random();

        List<Location> locations = locationDAO.getAll();

        int i;
        for (i = 0; i < n; i++) {
            LocalDate dataCasuale = LocalDate.now().plusDays(random.nextInt(365));
            String squadraDicasaCasuale = squadreSerieA[random.nextInt(squadreSerieA.length)];
            String squadraOspiteCasuale = squadreSerieA[random.nextInt(squadreSerieA.length)];
            int numeroGolDiCasaCasuale = random.nextInt(6);
            int numeroGolOspiteCasuale = random.nextInt(6);
            Location locationCasuale = locations.get(random.nextInt(locations.size()));
            PartitaDiCalcio partita = new PartitaDiCalcio(dataCasuale, "Partita di calcio", TipoEvento.PUBBLICO, 100,
                    locationCasuale,
                    squadraDicasaCasuale, squadraOspiteCasuale, numeroGolDiCasaCasuale, numeroGolOspiteCasuale);
            partitaDiCalcioDAO.save(partita);
        }
        System.out.println("Numero di partite di calcio inserite: " + i);
    }

    public static void inserisciConcertiCasuali(int n) {
        ConcertoDAO concertoDAO = new ConcertoDAO();
        GenericDAO<Location> locationDAO = new GenericDAO<Location>(Location.class);
        String[] band = { "Queen", "U2", "Metallica", "Guns N' Roses", "Nirvana", "AC/DC", "Bon Jovi", "Oasis",
                "Red Hot Chili Peppers", "Radiohead", "Pearl Jam", "Soundgarden", "Green Day", "No Doubt",
                "Foo Fighters",
                "R.E.M.", "Depeche Mode", "The Cure" };

        Random random = new Random();

        List<Location> locations = locationDAO.getAll();

        int i;
        for (i = 0; i < n; i++) {
            LocalDate dataCasuale = LocalDate.now().plusDays(random.nextInt(365));
            String artistaCasuale = band[random.nextInt(band.length)];
            String descrizioneCasuale = "Concerto di " + artistaCasuale;
            TipoEvento tipoEventoCasuale = TipoEvento.PUBBLICO;
            Integer numeroMassimoPartecipantiCasuale = random.nextInt(10000);
            Location locationCasuale = locations.get(random.nextInt(locations.size()));
            Genere genereCasuale = Genere.values()[random.nextInt(Genere.values().length)];
            Boolean inStreaming = i % 2 == 0;
            Concerto concerto = new Concerto(
                    dataCasuale, descrizioneCasuale, tipoEventoCasuale,
                    numeroMassimoPartecipantiCasuale, locationCasuale,
                    genereCasuale,
                    inStreaming);
            concertoDAO.save(concerto);
        }
        System.out.println("Numero di concerti inseriti: " + i);
    }

}
