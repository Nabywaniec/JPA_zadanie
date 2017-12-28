import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibRunner {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {
        Supplier supplier4 = new Supplier(4, "Media Markt", "Warszawa", "Czarnowiejska");
        Supplier supplier5 = new Supplier(5,"Avans", "Wrocław", "Wesoła");
        Category category = new Category(1,"Electronics");
        Product product4 = new Product(4,"XBOX",20,category, supplier4);
        Product product5= new Product(5,"JBL",30, category, supplier4);
        Product product6 =   new Product(6,"TV", 40, category, supplier5);
        Transaction_ transaction1 = new Transaction_(1,0);
        Transaction_ transaction2 = new Transaction_(2,0);
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(category);
        session.save(supplier4);
        session.save(supplier5);
        session.save(product4);
        session.save(product5);
        session.save(product6);
        session.save(transaction1);
        session.save(transaction2);

        transaction1.addProduct(product4);
        transaction1.addProduct(product5);
        transaction2.addProduct(product6);
        transaction2.addProduct(product4);

        System.out.println("Wypisanie");

        for(Product product : transaction1.getProducts()){
            System.out.println(product.toString());
        }
        for(Transaction_ transaction_ : product4.getTransactions()){
            System.out.println(transaction_);
        }

        tx.commit();
        session.close();
    }
    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory =
                    configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
