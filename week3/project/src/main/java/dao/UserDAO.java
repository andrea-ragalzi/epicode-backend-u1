package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.User;
import utils.JpaUtil;

public class UserDAO {
    public void save(User user) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error saving user: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<User> users) {
        for (User user : users) {
            save(user);
        }
    }

    public User getByCardNumber(Long cardNumber) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        User user = null;
        try {
            em.getTransaction().begin();
            user = em.find(User.class, cardNumber);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting user by card number: %s", cardNumber));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return user;
    }

    public List<User> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<User> users = null;
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            users = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all users: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return users;
    }

    public void Update(User user) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error updating user: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void removeByCardNumber(Long cardNumber) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, cardNumber);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error removing user: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}
