package bikeshop;

/**
 *
 * @author Daniel Bauman
 */
public class RepairPrice {
    private String brand;
    private String level;
    private int price;
    private int daysToRepair;

    public RepairPrice(String brand, String level, int price, int daysToRepair) {
        this.brand = brand;
        this.level = level;
        this.price = price;
        this.daysToRepair = daysToRepair;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDaysToRepair() {
        return daysToRepair;
    }

    public void setDaysToRepair(int daysToRepair) {
        this.daysToRepair = daysToRepair;
    }
    
    
}
