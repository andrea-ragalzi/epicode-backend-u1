package main.utils;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

import main.enumerate.Genere;
import main.model.Concerto;

public class ConcertoDAO extends GenericDAO<Concerto> {
    public ConcertoDAO() {
        super(Concerto.class);
    }

    public List<Concerto> getConcertiInStreaming(Boolean streaming) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Concerto> concerti;
        try {
            TypedQuery<Concerto> q = em.createNamedQuery("concertiInStreaming", Concerto.class);
            q.setParameter("streaming", streaming);
            concerti = q.getResultList();
        } catch (Exception e) {
            System.out.println(
                    String.format(
                            "Errore: impossibile ottenere la lista di concerti %s in streaming",
                            streaming ? "" : "non"));
            System.out.println(e.getMessage());
            concerti = null;
        } finally {
            em.close();
        }
        return concerti;
    }

    public List<Concerto> getConcertiPerGenere(List<Genere> listaGenere) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Concerto> concerti;
        try {
            TypedQuery<Concerto> q = em.createNamedQuery("concertiPerGenere", Concerto.class);
            q.setParameter("listaGenere", listaGenere);
            concerti = q.getResultList();
        } catch (Exception e) {
            System.out.println(
                    String.format(
                            "Errore: impossibile ottenere la lista di concerti per genere %s",
                            listaGenere.toString()));
            System.out.println(e.getMessage());
            concerti = null;
        } finally {
            em.close();
        }
        return concerti;
    }
}
