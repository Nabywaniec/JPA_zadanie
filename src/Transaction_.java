import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jacek on 2017-12-27.
 */
@Entity
public class Transaction_ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products = new LinkedList<>();

    public Transaction_(){

    }
    public Transaction_(int number, int quantity){
        this.number = number;
        this.quantity =quantity;
        this.products.clear();
    }

    public void addProduct( Product product){
        this.products.add(product);
        this.quantity += 1;
        product.addTransaction(this);
    }

    public List<Product> getProducts(){
        return this.products;
    }

}
