package michelangelodicello;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import michelangelodicello.dao.CatalogoDAO;
import michelangelodicello.dao.PrestitoDAO;
import michelangelodicello.dao.UtenteDAO;
import michelangelodicello.entities.*;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("progetto-be-w3");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        try {
            Utente u1 = new Utente("TESSERA001", "Michelangelo", "Di Cello", LocalDate.of(2003, 5, 8));
            Utente u2 = new Utente("TESSERA002", "Michele", "Fazio", LocalDate.of(1999, 8, 23));
            Utente u3 = new Utente("TESSERA003", "Mario", "Rossi", LocalDate.of(1998, 11, 2));

//            utenteDAO.save(u1);
//            utenteDAO.save(u2);
//            utenteDAO.save(u3);

            Libro l1 = new Libro("978-8804668237", "Il Nome della Rosa", LocalDate.of(1980, 1, 1), 600, "Storico", "Umberto Eco");
            Libro l2 = new Libro("978-8817107463", "I Promessi Sposi", LocalDate.of(1827, 6, 15), 720, "Romanzo Storico", "Alessandro Manzoni");
            Libro l3 = new Libro("978-8804711234", "Il Pendolo di Foucault", LocalDate.of(1988, 10, 25), 680, "Mistero", "Umberto Eco");
//
//            catalogoDAO.save(l1);
//            catalogoDAO.save(l2);
//            catalogoDAO.save(l3);

            Rivista r1 = new Rivista("ISSN-1120-5113", "Focus", LocalDate.of(2025, 10, 1), 120, Periodicita.MENSILE);
            Rivista r2 = new Rivista("ISSN-0028-0836", "Nature", LocalDate.of(2026, 1, 15), 80, Periodicita.SEMESTRALE);
            Rivista r3 = new Rivista("ISSN-0036-8075", "Science", LocalDate.of(2026, 2, 1), 95, Periodicita.SETTIMANALE);

//            catalogoDAO.save(r1);
//            catalogoDAO.save(r2);
//            catalogoDAO.save(r3);

            Prestito p1 = new Prestito(LocalDate.now().minusDays(5), LocalDate.now().plusDays(25), l1, u1);

            Prestito p2 = new Prestito(LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), r2, u1);

            Prestito p3 = new Prestito(LocalDate.now().minusDays(45), LocalDate.now().minusDays(15), r1, u2);

            Prestito p4 = new Prestito(LocalDate.now().minusDays(35), LocalDate.now().minusDays(5), l2, u3);

            Prestito p5 = new Prestito(LocalDate.now().minusDays(20), LocalDate.now().plusDays(10), l3, u2);
            p5.setDataRestituzioneEffettiva(LocalDate.now().minusDays(2));

//            prestitoDAO.save(p1);
//            prestitoDAO.save(p2);
//            prestitoDAO.save(p3);
//            prestitoDAO.save(p4);
//            prestitoDAO.save(p5);

            System.out.print("Ricerca ISBN: ");
            Catalogo resIsbn = catalogoDAO.findByIsbn("978-8817107463");
            System.out.println("Elemento risultante dal tuo isbn:" + resIsbn);

            System.out.print("Ricerca elementi per anno di pubblicazione: ");
            List<Catalogo> resAnno = catalogoDAO.findByAnnoPubblicazione(1980);
            System.out.println("Elementi trovati per l'anno corrispondente: " + resAnno);

            System.out.println("Ricerca Libri per autore: ");
            List<Libro> resAutore = catalogoDAO.findByAutore("Umberto Eco");
            System.out.println("Elementi trovati per l'autore: " + resAutore);

            System.out.println("Ricerca degli elementi per titolo: ");
            List<Catalogo> resTitolo = catalogoDAO.findByTitolo("Foc");
            System.out.println("Elementi trovati per il titolo inserito: " + resTitolo);

            System.out.println("Ricerca degli elementi attualmente in prestito: ");
            List<Catalogo> resPrestitiAtt = prestitoDAO.findElementiInPrestito("TESSERA001");
            System.out.println("Elementi trovati per l'utente: " + resPrestitiAtt);

            System.out.print("Ricerca prestiti scaduti totali non restituiti: ");
            List<Prestito> prestitiScaduti = prestitoDAO.findPrestitiScaduti();
            System.out.println("Elementi trovati: " + prestitiScaduti);

        } catch (Exception e) {
            System.err.println("Errore riscontrato durante l'esecuzione:");
            e.printStackTrace();
        }
    }
}
