import javax.persistence.Entity;

/**
 * Created by Jacek on 2017-12-28.
 */
@Entity
public class Customer extends Company {

    private double discount;

    public Customer(){
    }

    public double getDiscount(){
        return this.discount;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

}
