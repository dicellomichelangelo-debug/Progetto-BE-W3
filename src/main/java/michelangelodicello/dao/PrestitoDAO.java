package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Catalogo;
import michelangelodicello.entities.Prestito;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(prestito);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    public List<Catalogo> findElementiInPrestito(String numeroTessera) {
        return em.createQuery(
                        "SELECT p.catalogo FROM Prestito p WHERE p.utente.numeroTessera = :tessera AND p.dataRestituzioneEffettiva IS NULL",
                        Catalogo.class)
                .setParameter("tessera", numeroTessera)
                .getResultList();
    }

    public List<Prestito> findPrestitiScaduti() {
        return em.createQuery(
                        "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL",
                        Prestito.class)
                .setParameter("oggi", LocalDate.now())
                .getResultList();
    }
}
