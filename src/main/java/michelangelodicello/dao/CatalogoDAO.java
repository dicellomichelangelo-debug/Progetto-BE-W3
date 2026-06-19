package michelangelodicello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import michelangelodicello.entities.Catalogo;
import michelangelodicello.entities.Libro;

import java.util.List;

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
        return em.createQuery("SELECT c FROM Catalogo c WHERE c.isbn = :isbn", Catalogo.class)
                .setParameter("isbn", isbn)
                .getResultStream()
                .findFirst()
                .orElse(null);
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

    public List<Catalogo> findByAnnoPubblicazione(int anno) {
        return em.createQuery("SELECT c FROM Catalogo c WHERE YEAR(c.annoPubblicazione) = :anno", Catalogo.class)
                .setParameter("anno", anno)
                .getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    public List<Catalogo> findByTitolo(String parteTitolo) {
        return em.createQuery("SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER(:titolo)", Catalogo.class)
                .setParameter("titolo", "%" + parteTitolo + "%")
                .getResultList();
    }
}
