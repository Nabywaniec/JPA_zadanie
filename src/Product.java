

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jacek on 2017-12-14.
 */


@Entity
public class Product {



    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Transaction_> transactions = new LinkedList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int unitsInStock;


    @ManyToOne
    private Category categoryId;


    public Product(){

    }

    public Product(int id, String name, int unitsInStock, Category categoryId){
        this.id =id;
        this.name = name;
        this.unitsInStock = unitsInStock;
        this.categoryId = categoryId;
        this.transactions.clear();
    }

    public void addTransaction(Transaction_ transaction){
        this.transactions.add(transaction);
    }

    public List<Transaction_> getTransactions(){
        return this.transactions;
    }


}




