package main.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public void save(T object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile inserire %s nel DB",
                            object.toString()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public T getById(int id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        T object = null;
        try {
            em.getTransaction().begin();
            object = em.find(this.type, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile trovare %s con id %d",
                            this.type.getSimpleName(), id));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return object;
    }

    public void delete(T object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile eliminare %s dal DB",
                            object.toString()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void update(T object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile aggiornare %s nel DB",
                            object.toString()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<T> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<T> objects = new ArrayList<T>();
        try {
            em.getTransaction().begin();
            objects = em.createQuery("SELECT o FROM " + this.type.getSimpleName() + " o", this.type).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore: impossibile recuperare il numero di oggetti " + this.type.getSimpleName());
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return objects;
    }

}
