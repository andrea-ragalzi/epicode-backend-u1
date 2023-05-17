package main.java.com.example;

import javax.persistence.EntityManager;
import main.utils.JpaUtil;

import main.model.Evento;
import javax.persistence.EntityManagerFactory;

public class EventoDAO {

    private EntityManagerFactory emf;
    static EntityManager em;

    public EventoDAO(EntityManager entityManager) {
        emf = JpaUtil.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
        System.out.println(evento.toString() + " salvato nel DB!!");
    }

    public Evento getById(int id) {
        em.getTransaction().begin();
        Evento cliente = em.find(Evento.class, id);
        em.getTransaction().commit();
        return cliente;
    }

    public void delete(Evento evento) {
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
        System.out.println(evento.toString() + " eliminato dal DB!!");
    }

    public void refresh (Evento evento) {
        em.getTransaction().begin();
        em.refresh(evento);
        em.getTransaction().commit();
    } 

}
