package Hurricane.hurricane_system.src.main.java.com.model;

import java.util.UUID;

public class Shelter {
    private UUID id;
    private String name;
    private Location address;
    private int capacity;
    private int occupancy;
    private boolean petFriendly;
    private boolean accessible;
    private boolean medicalStaff;
    private boolean vetStaff;
    private String operationalStatus;

    public Shelter(String name, Location address, int capacity) {
        // Stub implementation
    }

    // Constructor 2
    public Shelter(UUID id, String name, Location address, int capacity, int occupancy, 
                   boolean petFriendly, boolean accessible, boolean medicalStaff, 
                   boolean vetStaff, String operationalStatus) {
        // Stub implementation
    }

    public void checkIn(String qrCode){
        // Stub
    }

    public void checkOut(String citienId){
        // Stub
    }

    public void updateInventory(ShelterResource resource){
        // Stub
    }
    
}
