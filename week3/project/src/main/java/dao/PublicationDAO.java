package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Publication;
import utils.JpaUtil;

import interfaces.IPublicationDAO;

public class PublicationDAO implements IPublicationDAO {

    public void save(Publication publication) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(publication);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error saving publication: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<Publication> publications) {
        for (Publication publication : publications) {
            save(publication);
        }
    }

    public Publication getByIsbn(String isbn) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Publication publication = null;
        try {
            em.getTransaction().begin();
            publication = em.find(Publication.class, isbn);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting publication by ISBN: %s", isbn));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return publication;
    }

    public List<Publication> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Publication> publications = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Publication> q = em.createQuery("SELECT p FROM Publication p", Publication.class);
            publications = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error getting all publications");
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return publications;
    }

    public void removeByIsbn(String isbn) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Publication publication = em.find(Publication.class, isbn);
            em.remove(publication);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error removing publication by ISBN: %s", isbn));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Publication> getByYear(int year) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Publication> publications = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Publication> q = em.createQuery("SELECT p FROM Publication p WHERE p.year = :year",
                    Publication.class);
            q.setParameter("year", year);
            publications = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting publications by year: %d", year));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return publications;
    }

    public List<Publication> getByAuthor(String author) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Publication> publications = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Publication> q = em.createQuery("SELECT p FROM Publication p WHERE p.author = :author",
                    Publication.class);
            q.setParameter("author", author);
            publications = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting publications by author: %s", author));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return publications;
    }

    public List<Publication> getByTitle(String title) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Publication> publications = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Publication> q = em.createQuery(
                    "SELECT p FROM Publication p WHERE LOWER(p.title) LIKE LOWER(:title)",
                    Publication.class);
            q.setParameter("title", "%" + title.toLowerCase() + "%");
            publications = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting publications by title: %s", title));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return publications;
    }

}