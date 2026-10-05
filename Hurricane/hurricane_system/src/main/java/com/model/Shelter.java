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

    public Shelter(String name, Location address, int capacity) { //Q: should operationalStatus be required?
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public Shelter(UUID id, String name, Location address, int capacity, int occupancy, 
                   boolean petFriendly, boolean accessible, boolean medicalStaff, 
                   boolean vetStaff, String operationalStatus) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.petFriendly = petFriendly;
        this.accessible =  accessible;
        this.medicalStaff = medicalStaff;
        this.vetStaff = vetStaff;
        this.operationalStatus = operationalStatus;
    }

    public void checkIn(String qrCode){
        occupancy++;
    }

    public void checkOut(String citienId){
        occupancy--;
    }

    /*public void updateInventory(ShelterResource resource){ //Q: Confused on how this will work/if it should be moved to another class?
        resource = resource;
    }
    */

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public Location getAddress() { return address; }
    public int getCapacity() { return capacity; }
    public int getOccupancy() { return occupancy; }
    public boolean isPetFriendly() { return petFriendly; }
    public boolean isAccessible() { return accessible; }
    public boolean hasMedicalStaff() { return medicalStaff; }
    public boolean hasVetStaff() { return vetStaff; }
    public String getOperationalStatus() { return operationalStatus; }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setAddress(Location address) { this.address = address; }
    
    public void setCapacity(int capacity) {
        /*if (capacity < occupancy) { //Q: not sure if this part is needed
            throw new IllegalArgumentException("Capacity can't be below current occupancy");
        } */ 
        this.capacity = capacity;
    }
    
    public void setPetFriendly(boolean petFriendly) { this.petFriendly = petFriendly; }
    public void setAccessible(boolean accessible) { this.accessible = accessible; }
    public void setMedicalStaff(boolean medicalStaff) { this.medicalStaff = medicalStaff; }
    public void setVetStaff(boolean vetStaff) { this.vetStaff = vetStaff; }
    public void setOperationalStatus(String operationalStatus) { this.operationalStatus = operationalStatus; }

}
