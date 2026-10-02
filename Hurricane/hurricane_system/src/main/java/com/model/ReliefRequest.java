package Hurricane.hurricane_system.src.main.java.com.model;

import java.util.*;

public class ReliefRequest {
    private UUID id;
    private DateTime createdAt;
    private Location location;
    private String assistance;
    private String description;
    private int people;
    private boolean specialNeeds;
    private Shelter destinationShelter;
    private DateTime estimatedArrival;
    private int priorityScore;
    private UrgencyTier urgency;
    private ReliefRequestStatus status;
    private ArrayList<RequestComment> comments;
    private ArrayList<RegisteredVictim> victims;

    public ReliefRequest(Location location, String assistance, int people) {
        // Stub implementation
    }

    // Constructor 2
    public ReliefRequest(UUID id, DateTime createdAt, Location location, String assistance, 
                         String description, int people, boolean specialNeeds, 
                         int priorityScore, UrgencyTier urgency, ReliefRequestStatus status) {
        // Stub implementation
    }

    public void submit(){
        // Stub
    }

    public void cancel(){
        // Stub
    }
    
    public void updateStatus(ReliefRequestStatus status) {
        // Stub
    }

    public void escalate() {
        // Stub
    }

    public void accept(User responder) {
        // Stub
    }

    public void decline() {
        // Stub
    }
    
    public void complete() {
        // Stub
    }

    public void addComment(RequestComment comment) {
        // Stub
    }

    public ArrayList<RequestComment> getComments() {
        return new ArrayList<RequestComment>();
    }

}
