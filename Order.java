package bikeshop;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Daniel Bauman
 */
public class Order implements Comparable{
   
    private int customerNumber;
    private LocalDate orderDate;
    private String promiseState;
    private LocalDate completionDate;
    private LocalDate dueDate;
    private int orderNumber;
    private List<RepairPrice> repairPrices;
    private Set<Integer> customerNumbers;
    private RepairPrice repairPrice;
    private String comments;
    private boolean isDone;
    public Order(int customerNumber, LocalDate orderDate, String brand, 
            String level, String comment, int orderNumber, List<RepairPrice> repairPrices,
            Set<Integer> customerNumbers) {
        this.customerNumber = customerNumber;
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.repairPrices = repairPrices;
        this.customerNumbers = customerNumbers;
        this.comments = comment;
        if(this.match(brand,level) == false)
            System.out.println("error creating order");
        else
            this.setDueDate(this.getDate()
                    .plusDays(this.getRepairPrice().getDaysToRepair()));
        this.promiseState = "Still working on it";
        this.completionDate = dueDate;
        this.isDone = false;
    }

    public boolean match(String brand, String level) {
        boolean hasCustomer = false;        
        if(this.customerNumbers.contains(this.getCustomerNumber()))
            hasCustomer = true;        
        boolean hasRepairPrice = false;
        for (RepairPrice rp: repairPrices) {
            if(rp.getBrand().equals(brand) && rp.getLevel().equals(level)) {
                hasRepairPrice = true;
                this.setRepairPrice(rp);
            }                
        }
        if(hasCustomer && hasRepairPrice)
            return true;
        return false;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    
    
    public String getComments() {
        return comments;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    public int getCustomerNumber() {
        return customerNumber;
    }

    public List<RepairPrice> getRepairPrices() {
        return repairPrices;
    }

    public void setRepairPrices(List<RepairPrice> repairPrices) {
        this.repairPrices = repairPrices;
    }

    public Set<Integer> getCustomerNumbers() {
        return this.customerNumbers;
    }
    
    public RepairPrice getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(RepairPrice repairPrice) {
        this.repairPrice = repairPrice;
    }
        
    public LocalDate getDate() {
        return orderDate;
    }
    public String getPromiseState() {
        return promiseState;
    }

    public void setPromiseState(String promiseState) {
        this.promiseState = promiseState;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    
    public String formattDate(LocalDate date) {
        return date.getMonth().name() + " " + date.getDayOfMonth() + ", " + date.getYear();
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    
    @Override
    public String toString() {  
        if(isDone) {
            return "Order #" +orderNumber + " from customer number #" + customerNumber 
                    + " at " + this.formattDate(orderDate)
                    + "\n\t ,status: " + promiseState 
                    + ", completed at " + this.formattDate(completionDate) + "\n\t"
                    + " ,with the price of " + repairPrice.getPrice() + "$" + "\n\t"
                    + " ,additional comments are: " + comments;
        }
        return "Order #" +orderNumber + " from customer number #" + customerNumber 
                + " at " + this.formattDate(orderDate)
                + "\n\t ,status: " + promiseState 
                + ", due date is " + this.formattDate(completionDate) + "\n\t"
                + " ,with the price of " + repairPrice.getPrice() + "$" + "\n\t"
                + " ,additional comments are: " + comments;
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
