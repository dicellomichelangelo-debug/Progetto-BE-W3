package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Catalogo;
import michelangelodicello.exception.NotFoundException;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo elemento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(elemento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    public Catalogo findByIsbn(String isbn) {
        Catalogo result = em.find(Catalogo.class, isbn);
        if (result == null) throw new NotFoundException(result);
        return result;
    }

    public void deleteByIsbn(String isbn) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Catalogo elemento = findByIsbn(isbn);
            em.remove(elemento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }
}
