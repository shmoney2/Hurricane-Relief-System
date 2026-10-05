package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * One person with an account in the system.
 */
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

    /**
     * Makes a brand new user (create account). Gets a fresh id.
     */
    public User(String userName, String firstName, String lastName, String password, Location location) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.roles = new ArrayList<>();
        this.emergencyContacts = new ArrayList<>();
    }

    /**
     * Rebuilds an existing user that was loaded from the JSON file. Keeps their saved id.
     */
    public User(UUID id, String userName, String firstName, String lastName, String password,
                Location location, SafetyCategory safety, ArrayList<UserRole> roles) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.safety = safety;
        this.roles = (roles == null) ? new ArrayList<>() : roles;
        this.emergencyContacts = new ArrayList<>();
    }

    /**
     * Checks a login attempt against this user.
     * Username ignores upper/lower case, password has to match exactly.
     * @return true if both match
     */
    public boolean signIn(String userName, String password) {
        if (userName == null || password == null) {
            return false;
        }
        return this.userName.equalsIgnoreCase(userName.trim()) && this.password.equals(password);
    }

    public void resetPassword() {
        // Stub
    }

    /**
     * Updates this user's profile info.
     */
    public void editProfile(String firstName, String lastName, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    public void markSafe(SafetyCategory category) {
        this.safety = category;
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

    // Getters
    public UUID getId() { return id; }
    public String getUserName() { return userName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPassword() { return password; }
    public Location getLocation() { return location; }
    public SafetyCategory getSafety() { return safety; }
    public List<UserRole> getRoles() { return roles; }
    public List<EmergencyContact> getEmergencyContacts() { return emergencyContacts; }
}
