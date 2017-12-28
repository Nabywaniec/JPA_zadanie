import javax.persistence.*;
import java.util.List;

/**
 * Created by Jacek on 2017-12-27.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany
    private List<Product> products;

    public Category(){

    }

    public Category(int id,String name){
        this.name = name;
        this.id = id;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return this.products;
    }
}
