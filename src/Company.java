import javax.persistence.*;
import java.util.List;

/**
 * Created by Jacek on 2017-12-28.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String companyName;
    private String zipCode;
    private String city;
    private String street;

    @OneToMany
    private List<Product> products;

    public Company(){

    }

    public Company( String companyName, String zipCode, String city, String street){
        this.companyName = companyName;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getProducts(){
        return this.products;
    }
}
