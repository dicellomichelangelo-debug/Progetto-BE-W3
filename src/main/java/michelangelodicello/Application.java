package michelangelodicello;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("progetto-be-w3");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
    }
}
