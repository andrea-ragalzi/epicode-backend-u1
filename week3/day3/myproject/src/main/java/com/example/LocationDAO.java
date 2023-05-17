package main.java.com.example;

import javax.persistence.EntityManager;
import main.utils.JpaUtil;
import main.model.Location;

import javax.persistence.EntityManagerFactory;

public class LocationDAO {

    private EntityManagerFactory emf;
    static EntityManager em;

    public LocationDAO(EntityManager entityManager) {
        emf = JpaUtil.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void save(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
        System.out.println(location.toString() + " salvato nel DB!!");
    }

    public Location getById(int id) {
        em.getTransaction().begin();
        Location location = em.find(Location.class, id);
        em.getTransaction().commit();
        return location;
    }

    public void delete(Location location) {
        em.getTransaction().begin();
        em.remove(location);
        em.getTransaction().commit();
        System.out.println(location.toString() + " eliminato dal DB!!");
    }

    public void refresh (Location location) {
        em.getTransaction().begin();
        em.refresh(location);
        em.getTransaction().commit();
    } 

}

