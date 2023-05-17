package main.java.com.example;

import javax.persistence.EntityManager;
import main.utils.JpaUtil;
import main.model.Partecipazione;

import javax.persistence.EntityManagerFactory;

public class PartecipazioneDAO {

    private EntityManagerFactory emf;
    static EntityManager em;

    public PartecipazioneDAO(EntityManager entityManager) {
        emf = JpaUtil.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void save(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
        System.out.println(partecipazione.toString() + " salvato nel DB!!");
    }

    public Partecipazione getById(int id) {
        em.getTransaction().begin();
        Partecipazione partecipazione = em.find(Partecipazione.class, id);
        em.getTransaction().commit();
        return partecipazione;
    }

    public void delete(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.remove(partecipazione);
        em.getTransaction().commit();
        System.out.println(partecipazione.toString() + " eliminato dal DB!!");
    }

    public void refresh (Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.refresh(partecipazione);
        em.getTransaction().commit();
    } 

}

