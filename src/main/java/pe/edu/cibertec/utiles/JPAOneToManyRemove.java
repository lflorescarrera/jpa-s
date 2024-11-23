package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;

public class JPAOneToManyRemove {

    public static void main(String[] args) {

        // Referencias a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // Referenciar a una categoria
        Categoria categoria = em.find(Categoria.class, "C2");

        // Remove
        em.getTransaction().begin();
        em.remove(categoria);
        em.getTransaction().commit();
    }
}
