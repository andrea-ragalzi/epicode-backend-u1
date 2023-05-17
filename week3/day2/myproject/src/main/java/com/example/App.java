package main.java.com.example;

import javax.persistence.EntityManagerFactory;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import main.utils.JpaUtil;
import main.model.Evento;
import main.model.TipoEvento;

public class App {
    static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Evento eventoToSave1 = new Evento(
                LocalDate.now(),
                "Primo evento",
                TipoEvento.PRIVATO,
                33);

        EventoDAO dao = new EventoDAO(em);
        // dao.save(eventoToSave1);
        eventoToSave1 = dao.getById(1);
        dao.delete(eventoToSave1);
    }
}
