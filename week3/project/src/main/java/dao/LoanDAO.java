package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Loan;
import utils.JpaUtil;

import interfaces.ILoanDAO;

public class LoanDAO implements ILoanDAO {
    public void save(Loan loan) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(loan);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error saving loan: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<Loan> loans) {
        for (Loan loan : loans) {
            save(loan);
        }
    }

    public Loan getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Loan loan = null;
        try {
            em.getTransaction().begin();
            loan = em.find(Loan.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting loan by id: %s", id));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loan;
    }

    public List<Loan> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Loan> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Loan> query = em.createQuery(
                    "SELECT l FROM Loan l", Loan.class);
            loans = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all loans: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loans;
    }

    public void update(Loan loan) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(loan);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error updating loan: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void removeById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Loan loan = em.find(Loan.class, id);
            em.remove(loan);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error removing loan by id: %s", id));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Loan> getLoansByCardNumber(long cardNumber) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Loan> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Loan> query = em.createQuery(
                    "SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber",
                    Loan.class);
            query.setParameter("cardNumber", cardNumber);
            loans = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting loans by card number: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loans;
    }

    public List<Loan> getExpiredNotReturnedLoans() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Loan> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Loan> query = em.createQuery(
                    "SELECT l FROM Loan l WHERE l.returnDate IS NULL AND l.endDate < CURRENT_DATE",
                    Loan.class);
            loans = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error getting expired not returned loans");
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loans;
    }

}