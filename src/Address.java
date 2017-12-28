import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Jacek on 2017-12-27.
 */
@Entity
@Embeddable
public class Address {

    @Id
    private int id;
    private String street;
    private String city;
    private String zipCode;

    public Address(){
    }

    public Address(int id, String street, String city, String zipCode){
        this.street =street;
        this.city = city;
        this.zipCode =zipCode;
        this.id = id;
    }

}
