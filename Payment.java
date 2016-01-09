package bikeshop;

import java.time.LocalDate;

/**
 *
 * @author Daniel Bauman
 */
public class Payment implements Comparable{
    private int amount;
    private LocalDate date;
    private int customerNumber;

    public Payment( int customerNumber, LocalDate date, int amount) {
        this.amount = amount;
        this.date = date;
        this.customerNumber = customerNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    public String formattDate(LocalDate date) {
        return date.getMonth().name() + " " + date.getDayOfMonth() + ", " + date.getYear();
    }
    
    @Override
    public String toString() {
        return "Payment from customer #" + this.getCustomerNumber() + " at " +
                this.formattDate(this.getDate()) + ", amount payed: " + this.getAmount() + "$";
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(Order.class)) {
            if(this.getDate().isBefore(((Order)o).getDate()))
                return -1;
            else if(this.getDate().isEqual(((Order)o).getDate()))
                return 0;
            return 1;
        } else {
            if(this.getDate().isBefore(((Payment)o).getDate()))
                return -1;
            else if(this.getDate().isEqual(((Payment)o).getDate()))
                return 0;
            return 1;
        }
    }
    
    
}
