package pe.edu.cibertec.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pe.edu.cibertec.domain.Libro;

import java.util.List;

public class JPAQuery {

    public static void main(String[] args) {

        // Referencias a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // Select
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l", Libro.class);

        // Select - where
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor = :autor", Libro.class);
        //query.setParameter("autor", "Claudia");

        // Select - where - comparativos (> < =)
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.precio > :precio", Libro.class);
        //query.setParameter("precio", 50);

        // Select - where - between
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.precio between :inicio and :fin", Libro.class);
        //query.setParameter("inicio", 30);
        //query.setParameter("fin", 50);

        // Select - where - in
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor in ('Cesar', 'Claudia')", Libro.class);

        // Select - valores escalares
        //TypedQuery<String> query = em.createQuery("select l.autor from Libro l where l.autor in ('Cesar', 'Claudia')", String.class);

        // Select - valores escalares - distinct
        //TypedQuery<String> query = em.createQuery("select distinct l.autor from Libro l where l.autor in ('Cesar', 'Claudia')", String.class);

        // Select - valores escalares - upper
        //TypedQuery<String> query = em.createQuery("select distinct upper(l.autor) from Libro l where l.autor in ('Cesar', 'Claudia')", String.class);

        // Select - order by
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l order by l.precio", Libro.class);

        // Select - group by
        //(1) TypedQuery<Object[]> query = em.createQuery("select l.autor, count(l) from Libro l group by l.autor", Object[].class);

        // Select - is null
        //TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor is null", Libro.class);

        // Select - like
        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.titulo like 'c%'", Libro.class);

        // Obtener resultados
        List<Libro> resultado = query.getResultList();
        resultado.forEach(System.out::println);
        //resultado.forEach(item -> System.out.println(item.getTitulo()));
        //(1) resultado.forEach(elemento -> System.out.println("Autor: " + elemento[0] + " -- " + "Cantidad: " + elemento[1]));
    }
}
