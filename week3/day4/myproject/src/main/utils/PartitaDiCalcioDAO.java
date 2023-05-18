package main.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.model.PartitaDiCalcio;

public class PartitaDiCalcioDAO extends GenericDAO<PartitaDiCalcio> {
    public PartitaDiCalcioDAO() {
        super(PartitaDiCalcio.class);
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<PartitaDiCalcio> partiteVinteInCasa;
        try {
            TypedQuery<PartitaDiCalcio> q = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
            partiteVinteInCasa = q.getResultList();
        } catch (Exception e) {
            System.out.println(
                    "Errore: impossibile ottenere le partite vinte in casa");
            System.out.println(e.getMessage());
            partiteVinteInCasa = null;
        } finally {
            em.close();
        }
        return partiteVinteInCasa;
    }
}
