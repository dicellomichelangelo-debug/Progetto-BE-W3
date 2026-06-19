package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Utente;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(utente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    public Utente findByNumeroTessera(String numeroTessera) {
        return em.createQuery("SELECT u FROM Utente u WHERE u.numeroTessera = :tessera", Utente.class)
                .setParameter("tessera", numeroTessera)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
