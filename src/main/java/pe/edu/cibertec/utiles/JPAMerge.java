package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Libro;

public class JPAMerge {

    public static void main(String[] args) {

        // Referencias a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // Referencias libro
        Libro libro = em.find(Libro.class, "A1");
        libro.setAutor("Gabriel García Márquez");

        // Actualizar libro
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }
}
