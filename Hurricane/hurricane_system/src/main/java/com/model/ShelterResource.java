package Hurricane.hurricane_system.src.main.java.com.model;

import java.time.LocalDateTime;

public class ShelterResource {
    private String type;
    private int quantity;
    private DateTime availableUntil;
    private int lowStockThreshold;

    public ShelterResource(String type, int quantity){
        this.type = type;
        this.quantity = quantity;
    }

    public ShelterResource(String type, int quantity, DateTime availableUntil, int lowStockThreshold){
        this.type = type;
        this.quantity = quantity;
        this.availableUntil = availableUntil;
        this.lowStockThreshold = lowStockThreshold;
    }

    public boolean checkStockLevel (){ //Q: This should probably be a string?
        return (quantity > lowStockThreshold) ? true : false;
    }

// Getters
public String getType() { return type; }
public int getQuantity() { return quantity; }
public DateTime getAvailableUntil() { return availableUntil; }
public int getLowStockThreshold() { return lowStockThreshold; }

// Setters
public void setQuantity(int quantity) {
    if (quantity < 0) {
        throw new IllegalArgumentException("Quantity can't be negative");
    }
    this.quantity = quantity;
}

public void setAvailableUntil(DateTime availableUntil) { this.availableUntil = availableUntil; }
public void setLowStockThreshold(int lowStockThreshold) { this.lowStockThreshold = lowStockThreshold; }    

}
