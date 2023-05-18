package main.utils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

    public void save(T object) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            System.out.println(
                    String.format("%s inserito nel DB!!", object.toString()));
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile inserire %s nel DB",
                            object.toString()));
        } finally {
            em.close();
        }
    }

    public T getById(int id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        T object = null;
        try {
            em.getTransaction().begin();
            object = em.find(getType(), id);
            em.getTransaction().commit();
            System.out.println(
                    String.format(
                            "%s con id %d trovato: %s",
                            getType().getSimpleName(), id, object.toString()));
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile trovare %s con id %d",
                            getType().getSimpleName(), id));
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
            System.out.println(
                    String.format("%s eliminato dal DB!!", object.toString()));
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile eliminare %s dal DB",
                            object.toString()));
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
            System.out.println(
                    String.format("%s aggiornato nel DB!!", object.toString()));
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore: impossibile aggiornare %s nel DB",
                            object.toString()));
        } finally {
            em.close();
        }
    }

    public List<T> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<T> objects = new ArrayList<T>();
        try {
            em.getTransaction().begin();
            objects = em.createQuery("SELECT o FROM " + getType().getSimpleName() + " o", getType()).getResultList();
            em.getTransaction().commit();
            System.out.println(String.format("Numero di oggetti %s: %s", getType().getSimpleName(), objects.size()));
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore: impossibile recuperare il numero di oggetti " + getType().getSimpleName());
        } finally {
            em.close();
        }
        return objects;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getType() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

}
