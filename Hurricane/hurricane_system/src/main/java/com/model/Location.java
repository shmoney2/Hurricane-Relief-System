package Hurricane.hurricane_system.src.main.java.com.model;

import java.util.UUID;


public class Location {
    private UUID id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private double latitude;
    private double longitude;

    public Location(String addressLine1, String city, String state, String zipCode) {
        this.id = UUID.randomUUID();
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Location(double latitude, double longitude) {
        this.id = UUID.randomUUID();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(UUID id, String addressLine1, String addressLine2, String city, String state, String zipCode, double latitude, double longitude) {
        this.id = id;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String formatAddress() {
        String line2 = (addressLine2 == null || addressLine2.isEmpty()) ? "" : ", " + addressLine2;
        return addressLine1 + line2 + ", " + city + ", " + state + " " + zipCode;
    }

    public UUID getId() { return id; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getCity() { return city; }
}
