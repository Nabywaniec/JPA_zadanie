
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Jacek on 2017-12-14.
 */
@Entity
public class Supplier extends Company{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private int bankAccountNumber;
    private String street;
    private String city;
    private String zipCode;

    @Embedded
    private Address address;

    @OneToMany
    private List<Product> products = new LinkedList<>();

    public Supplier(){
    }

    public Supplier(int id, String name, String street, String city){

        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.products.clear();
    }

    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> getProducts(){return this.products;}
    public void setAddress(Address address){
        this.address =address;
    }
    public void setBankAccountNumber(int bankAccountNumber){
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }
}
