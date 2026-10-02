package Hurricane.hurricane_system.src.main.java.com.model;

import java.util.*;

public class User {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private Location location;
    protected SafetyCategory safety;
    protected List<UserRole> roles;
    private List<EmergencyContact> emergencyContacts;

    public User(String userName, String firstName, String lastName, String password, Location location) {
        // Stub implementation
    }

    // Constructor 2
    public User(UUID id, String userName, String firstName, String lastName, String password, 
                Location location, SafetyCategory safety, ArrayList<UserRole> roles) {
        // Stub implementation
    }

    public boolean signIn(String userName, String password) {
        return true; 
    }

    public void resetPassword() {
        // Stub
    }

    public void editProfile() {
        // Stub
    }

    public void markSafe(SafetyCategory category) {
        // Stub
    }

    public void shareLocation() {
        // Stub
    }

    public void isGuest() {
        // Stub
    }

    public void Languages() {
        // Stub
    }
    
}
