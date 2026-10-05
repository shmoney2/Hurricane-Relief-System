package Hurricane.hurricane_system.src.main.java.com.model;

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

}
