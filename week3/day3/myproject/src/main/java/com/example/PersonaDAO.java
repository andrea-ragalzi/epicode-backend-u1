package main.java.com.example;

import javax.persistence.EntityManager;
import main.utils.JpaUtil;

import main.model.Persona;

import javax.persistence.EntityManagerFactory;

public class PersonaDAO {

    private EntityManagerFactory emf;
    static EntityManager em;

    public PersonaDAO(EntityManager entityManager) {
        emf = JpaUtil.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void save(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        System.out.println(persona.toString() + " salvato nel DB!!");
    }

    public Persona getById(int id) {
        em.getTransaction().begin();
        Persona cliente = em.find(Persona.class, id);
        em.getTransaction().commit();
        return cliente;
    }

    public void delete(Persona persona) {
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
        System.out.println(persona.toString() + " eliminato dal DB!!");
    }

    public void refresh (Persona persona) {
        em.getTransaction().begin();
        em.refresh(persona);
        em.getTransaction().commit();
    } 

}

