package bikeshop;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel Bauman
 */
public class BikeShop {

    /**
     * @param args the command line arguments
     */
    private int customerCount;
    private int orderCount;
    private Map<Integer,Customer> cusomters;
    private Map<Integer,Order> orders;
    private List<Payment> payments;
    private List<RepairPrice> repairprices;
    private List<String> commands;
    
    public BikeShop() {
        cusomters = new HashMap();
        orders = new HashMap();
        payments = new ArrayList();
        repairprices = new ArrayList();
        commands = new ArrayList();
        orderCount = 0;
        customerCount = 0;
        doRun = true;
    }
    
    public Map<Integer,Customer> getCusomters() {
        return cusomters;
    }

    public void putCusomter(int x,Customer c) {
        this.cusomters.put(x,c);
    }

    public Map<Integer,Order> getOrders() {
        return orders;
    }

    public void putOrder(int x, Order o) {
        this.orders.put(x,o);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment p) {
        this.payments.add(p);
    }

    public List<RepairPrice> getRepairprices() {
        return repairprices;
    }

    public void addRepairprice(RepairPrice r) {
        this.repairprices.add(r);
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String c) {
        this.commands.add(c);
    }
    
    public LocalDate formatDate(String unforamttedDate){
        String[] partsOfDate = unforamttedDate.split("/");
        int month = Integer.parseInt(partsOfDate[0]);
        int day = Integer.parseInt(partsOfDate[1]);
        int year = Integer.parseInt(partsOfDate[2]);
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
    
    public Integer[] sortIntegerSet(Set<Integer> numbers) {
        Integer[] ArrayOfNumbers = new Integer[numbers.size()];
        int x = 0;
        for (int i: numbers) {
            ArrayOfNumbers[x] = i;
            x++;
        }        
        for (int i: ArrayOfNumbers) {
            for (int j = 0; j < ArrayOfNumbers.length-1; j++) {
                if(ArrayOfNumbers[j] > ArrayOfNumbers[j+1]) {
                    int temp = ArrayOfNumbers[i];
                    ArrayOfNumbers[i] = ArrayOfNumbers[i+1];
                    ArrayOfNumbers[i+1] = temp;
                }                    
            }
        }
        return ArrayOfNumbers;
    }
    
    public String[] sortNames(Collection<Customer> customers) {
        String[] names = new String[customers.size()];
        int x = 0;
        for (Customer c: customers) {
            String name = c.getLastname() + " " + c.getFirstname();
            names[x] = name;
            x++;
        }
        for (String name: names) {
            for (int i = 0; i < names.length-1; i++) {
                if (names[i].compareToIgnoreCase(names[(i+1)]) > 0) {
                    String temp = names[i];
                    names[i] = names[i+1];
                    names[i+1] = temp;                    
                }
            }
        }
        return names;
    }
    
    public int getMax(Set<Integer> numbers) {
        int max = 0;
        if(numbers.isEmpty())
            return max;
        for (int n: numbers) {
            if(n > max)
                max = n;            
        }
        return max;     
    }
    
    public Order[] sortByDateOrders(Collection<Order> Orders) {
        Order[] ordersArray = new Order[Orders.size()];
        int x = 0;
        for (Order o: Orders) {
            ordersArray[x] = o;
            x++;
        }
        for (Order o: ordersArray) {
            for (int i = 0; i < Orders.size()-1; i++) {
                if(ordersArray[i].compareTo(ordersArray[(i+1)]) == 1){
                    Order temp = ordersArray[i];
                    ordersArray[i] = ordersArray[(i+1)];
                    ordersArray[(i+1)] =  temp;
                }
                    
            }
        }
        
        return ordersArray;
    }
    public Payment[] sortByDatePayment(List<Payment> Payments) {
        Payment[] paymentsArray = new Payment[Payments.size()];
        int x = 0;
        for(Payment p: payments) {
            paymentsArray[x] = p;
            x++;
        }
        for (Payment p: paymentsArray) {
            for (int i = 0; i < paymentsArray.length-1; i++) {
                if(paymentsArray[i].compareTo(paymentsArray[(i+1)]) == 1){
                    Payment temp = paymentsArray[i];
                    paymentsArray[i] = paymentsArray[(i+1)];
                    paymentsArray[(i+1)] =  temp;
                }
                    
            }
        }
        
        return paymentsArray;
    }
    
    public ArrayList<Comparable> sortByDateBoth(Collection<Order> Orders, List<Payment> Payments) {
        ArrayList<Comparable> sorted = new ArrayList();
        sorted.addAll(Orders);
        sorted.addAll(Payments);
        for(Object o: sorted) {
            for (int i = 0; i < sorted.size()-1; i++) {
                if(sorted.get(i).compareTo(sorted.get(i+1)) == 1){
                    Comparable temp = sorted.get(i);
                    sorted.set(i, sorted.get(i+1));
                    sorted.set(i+1, temp);
                }    
            }
        }
        return sorted;
    }
    
    private boolean doRun;
    public void help() {
        System.out.println("\nCommands for Bike Shop:");
        System.out.println("");
        System.out.println("    quit - Quit the Bike System");
        System.out.println("    help - Print help");
        System.out.println("");
        System.out.println("    addrp brand level price days - Add Repair Price");
        System.out.println("    addc firstname lastname - Add Customer");
        System.out.println("    addo customerNumber date(mm/dd/yyyy) brand level comments - Add Order");
        System.out.println("    addp customerNumber date(mm/dd/yyyy) amount - Add payment");
        System.out.println("    comp OrderNumber completionDate(mm/dd/yyyy) - mark order orderNumber completed");
        System.out.println("");
        System.out.println("    printrp - Print Repair Prices");
        System.out.println("    printcnum - Print Customers by Customer Number");
        System.out.println("    printcname - Print Customers by Customer Name");
        System.out.println("    printo - print orders");
        System.out.println("    printp - prints payments");
        System.out.println("    printt - print transactions");   
        System.out.println("");
        System.out.println("    readc filename - Read commands from disk file filename");
        System.out.println("    savebs filename - save Bike Shop as file of commands in file filename");
        System.out.println("    restorebs filename - restore a previously saved bike shop from file filename");
        System.out.println("");
    }

    public boolean shouldRun() {
        return doRun;
    }

    public void setDoRun(boolean doRun) {
        this.doRun = doRun;
    }
           
    public void processCommand(String command, boolean fromDisk) {
        if(command.equals("help"))
            this.help();
        else if(command.equals("quit")) {
            this.setDoRun(false);
            System.out.println("System done. (you may quit)");
        } else if(command.startsWith("addrp")) {
            this.addCommand(command);
            String[] atrForAddrp = command.split(" "); //atributes
            String brand = atrForAddrp[1];
            String level = atrForAddrp[2];
            int price = Integer.parseInt(atrForAddrp[3]);
            int days = Integer.parseInt(atrForAddrp[4]);
            RepairPrice rp = new RepairPrice(brand, level, price, days);
            this.addRepairprice(rp);            
        } else if(command.startsWith("addc")) {
            String[] atrForAddc = command.split(" ");
            String customerFirstName = atrForAddc[1];
            String customerLastName = atrForAddc[2];
            int customerNumber;
            if(!fromDisk) {                
                customerNumber = this.getMax(cusomters.keySet()) + 1;                           
            } else {                
                customerNumber = customerCount;                
            }
            this.addCommand("rncn " + customerNumber);
            this.addCommand(command);
            Customer customer = new Customer(customerFirstName, customerLastName, customerNumber);
            this.putCusomter(customer.getCustomerNumber(), customer);
        } else if(command.startsWith("addo")) {       
            String[] atrForAddo = command.split(" ");
            int cusomerNumber = Integer.parseInt(atrForAddo[1]);
            String unforamttedDate = atrForAddo[2];
            String brand = atrForAddo[3];
            String level = atrForAddo[4];
            String comments = "";
            for (int i = 5; i < atrForAddo.length; i++) {
                comments += atrForAddo[i] + " ";
            }            
            LocalDate date = formatDate(unforamttedDate);
            int orderNumber;
            if(fromDisk) {
                 orderNumber = this.orderCount;
            } else {
                orderNumber = this.getMax(orders.keySet()) +1;
            }            
            this.addCommand("rnon " + orderNumber);
            this.addCommand(command);
            Order order = new Order(cusomerNumber, date, brand, level, comments, orderNumber,
                    repairprices,cusomters.keySet());
            this.putOrder(orderNumber,order);
        } else if(command.startsWith("addp")) {
            String[] atrForAddp = command.split(" ");
            int customerNumber = Integer.parseInt(atrForAddp[1]);
            String unforamttedDate = atrForAddp[2];            
            LocalDate date = formatDate(unforamttedDate);
            int amount = Integer.parseInt(atrForAddp[3]);
            Payment payment = new Payment(customerNumber, date, amount);
            payments.add(payment);
            this.addCommand(command);
        } else if(command.startsWith("comp")) {
            String[] atrForComp = command.split(" ");
            int orderNumber = Integer.parseInt(atrForComp[1]);
            String unformattedDate = atrForComp[2];
            LocalDate completionDate = formatDate(unformattedDate);
            orders.get(orderNumber).setCompletionDate(completionDate);
            orders.get(orderNumber).setPromiseState("all done!");
            orders.get(orderNumber).setIsDone(true);
            this.addCommand(command);
        } else if(command.equals("printrp")) {
            System.out.println("brand\tlevel\tprice\tdays to repair");
            for(RepairPrice rp: repairprices) {
                System.out.println(rp.getBrand() + "\t" +
                        rp.getLevel() + "\t" + rp.getPrice() + "\t" + rp.getDaysToRepair());
            }
        } else if(command.equals("printcnum")) {
            Integer[] customerNumbers = sortIntegerSet(cusomters.keySet());
            System.out.println("C#\tfirst name\tlast name");
            for (int customerNumber: customerNumbers) {
                Customer currentCustomer = cusomters.get(customerNumber);
                System.out.println(customerNumber + "\t" + currentCustomer.getFirstname()
                + "\t" + currentCustomer.getLastname());
            }
        } else if(command.equals("printcname")) {
            Collection<Customer> customersCollection = cusomters.values();
            String[] namesByOrder = sortNames(customersCollection);
            System.out.println("Lastname Firstname");
            for (String name: namesByOrder) {
                System.out.println(name);
            }
        } else if(command.equals("printo")) {
            Order[] ordersByDate = this.sortByDateOrders(orders.values());
            for (Order order: ordersByDate) {
                System.out.println(order);
            }
        } else if(command.equals("printp")) {
            Payment[] paymentsByDate = this.sortByDatePayment(payments);
            for (Payment p: paymentsByDate) {
                System.out.println(p);
            }
        } else if(command.equals("printt")) {
            ArrayList<Comparable> sortedTransactions= sortByDateBoth(orders.values(), payments);
            System.out.println("Transactions by Date: (orders and payments)");
            for (Comparable transaction: sortedTransactions) {
                System.out.println(transaction);
            }
        } else if(command.startsWith("readc")) {
            String[] atrForReadc = command.split(" ");
            String filename = "";
            for (int i = 1; i < atrForReadc.length; i++) {
                filename += atrForReadc[i];
                System.out.println(filename);
            }
            try {
                FileManager fm = new FileManager(filename);
                ArrayList<String> commandsFromFile = fm.read();
                for(String c: commandsFromFile) {
                    System.out.println(c);
                    this.processCommand(c,true);
                }
                System.out.println("done");
            } catch (IOException ex) {
                System.out.println("failed to find/read from the file");
            }
            this.addCommand(command);
        } else if(command.startsWith("rncn")) {
            String[] atrForRncn = command.split(" ");
            customerCount = Integer.parseInt(atrForRncn[1]);
        } else if(command.startsWith("rnon")) {
            String[] atrForRnon = command.split(" ");
            orderCount = Integer.parseInt(atrForRnon[1]);
        } else if(command.startsWith("savebs")) {
            try {
                String[] atrForSavebs = command.split(" ");
                String filename = "";
                for (int i = 1; i < atrForSavebs.length; i++) {
                    filename += atrForSavebs[i];
                    System.out.println(filename);
                }
                FileManager fm = new FileManager(filename);
                for (String c: commands) {
                    fm.writeLine(c);
                }
            } catch (IOException ex) {
                System.out.println("failed to write to file.");
            }
        } else if(command.startsWith("restorebs")) {
            String[] atrForRestorebs = command.split(" ");
            String filename = "";
            for (int i = 1; i < atrForRestorebs.length; i++) {
                filename += atrForRestorebs[i];
            }
            this.commands.clear();
            this.cusomters.clear();
            this.customerCount = 0;
            this.orderCount = 0;
            this.orders.clear();
            this.payments.clear();
            this.repairprices.clear();
            try {
                FileManager fm = new FileManager(filename);
                ArrayList<String> newCommands = fm.read();
                for (String c: newCommands) {
                    this.processCommand(c, true);                    
                }
            } catch (IOException ex) {
                System.out.println("couldn't restore from file");
            }
        } 
    }
    
    public static void main(String[] args) {        
        BikeShop shop = new BikeShop();
        shop.help();
        Scanner in = new Scanner(System.in);
        System.out.println("");
        while(shop.shouldRun()) {
            String newCommand = in.nextLine();                        
            shop.processCommand(newCommand,false);                                    
        }
    }
    
}
