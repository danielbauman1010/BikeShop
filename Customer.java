package bikeshop;

/**
 *
 * @author Daniel Bauman
 */
public class Customer {
    private String lastname;
    private String firstname;
    private int customerNumber;

    public Customer(String firstname, String lastname, int customerNumber) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.customerNumber = customerNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    @Override
    public String toString() {
        return this.getFirstname() + " " + this.getLastname();
    }
    
}
