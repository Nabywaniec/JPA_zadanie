/**
 * Created by Jacek on 2017-12-27.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPARunner {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
//do something

        Supplier supplier4 = new Supplier(4, "Media Markt", "Warszawa", "Czarnowiejska");
        Supplier supplier5 = new Supplier(5,"Avans", "Wrocław", "Wesoła");
        Category category2 = new Category(10,"Electronics");
        Product product4 = new Product(4,"XBOX",20,category2, supplier4);
       Product product5= new Product(5,"JBL",30, category2, supplier4);
        Product product6 =   new Product(6,"TV", 40, category2, supplier5);


         em.persist(supplier4);
        em.persist(supplier5);
        em.persist(category2);
        em.persist(product4);
        em.persist(product5);
        em.persist(product6);



        etx.commit();
        em.close();
    }
}
