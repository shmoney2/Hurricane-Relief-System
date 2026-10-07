package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class ReliefSystem {

    private static ReliefSystem facade;

    //Q: These should be top priority to fix
    private UserManagement userManagement;
    private ReliefManagement reliefManagement;
    private ShelterManagement shelterManagement;
    private HurricaneEventManagement eventManagement;


    // Q: Need to make these managers
    private ArrayList<GeographicRegion> regions;
    private ArrayList<HazardReport> hazards;

    private User currentUser;
    private ReliefRequest currentRequest;
    private Shelter currentShelter;

    private ReliefSystem() {
        userManagement = UserManagement.getInstance();
        reliefManagement = ReliefManagement.getInstance();
        shelterManagement = ShelterManagement.getInstance();
        eventManagement = HurricaneEventManagement.getInstance();
        regions = new ArrayList<>();
        hazards = new ArrayList<>();
    }

    public static ReliefSystem getInstance() {
        if (facade == null) {
            facade = new ReliefSystem();
        }
        return facade;
    }

    // ---------- helpers ----------

    private void requireLogin() {
        if (currentUser == null) {
            throw new IllegalStateException("No user is signed in");
        }
    }

    private Admin requireAdmin() {
        requireLogin();
        if (!(currentUser instanceof Admin)) {
            throw new IllegalStateException("This action requires an admin");
        }
        return (Admin) currentUser;
    }

    private ReliefRequest requireRequest() {
        if (currentRequest == null) {
            throw new IllegalStateException("No relief request is selected");
        }
        return currentRequest;
    }

    private Shelter requireShelter() {
        if (currentShelter == null) {
            throw new IllegalStateException("No shelter is selected");
        }
        return currentShelter;
    }

    // ---------- users ----------

    public User registerUser(String userName, String firstName, String lastName,
                             String password, Location location) {
        if (userManagement.getUserByUserName(userName) != null) {
            throw new IllegalArgumentException("Username already taken: " + userName);
        }
        User user = new User(userName, firstName, lastName, password, location);
        userManagement.addUser(user);
        return user;
    }

    public boolean signIn(String userName, String password) {
        User user = userManagement.getUserByUserName(userName);
        if (user != null && user.signIn(userName, password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void signOut() {
        currentUser = null;
        currentRequest = null;
        currentShelter = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    //Q: Need to polish this and make EmergencyContact class
    public void addEmergencyContact(String name, String phone, String relationship) {
        requireLogin();
        String[] parts = name.trim().split("\\s+", 2);
        String first = parts[0];
        String last = parts.length > 1 ? parts[1] : "";
        currentUser.getEmergencyContacts()
                .add(new EmergencyContact(first, last, phone, relationship));
    }

    public void markUserSafe(SafetyCategory category) {
        requireLogin();
        currentUser.markSafe(category);
    }

    public void shareUserLocation() {
        requireLogin();
        currentUser.shareLocation();
    }

    // ---------- relief requests ----------

    //Q: Need to implement Relief Manager
    public ReliefRequest submitReliefRequest(Location location, String assistance, int people) {
        requireLogin();
        ReliefRequest request = new ReliefRequest(location, assistance, people);
        request.submit();
        reliefManagement.addReliefRequest(request);
        currentRequest = request;
        return request;
    }

    public ReliefRequest selectRequest(UUID requestId) {
        ReliefRequest request = reliefManagement.getReliefRequest(requestId);
        if (request == null) {
            throw new IllegalArgumentException("No request with id " + requestId);
        }
        currentRequest = request;
        return request;
    }

    public ReliefRequestStatus getReliefStatus() {
        return requireRequest().getStatus();
    }

    public void updateRequestStatus(ReliefRequestStatus status) {
        requireRequest().updateStatus(status);
    }

    public void claimRequest() {
        requireLogin();
        requireRequest().accept(currentUser);
    }

    public void respondToRequest() {
        requireLogin();
        requireRequest().updateStatus(ReliefRequestStatus.HELP_EN_ROUTE);
    }

    public void escalateRequest() {
        requireRequest().escalate();
    }

    public void cancelRequest() {
        requireRequest().cancel();
    }

    public void completeRequest() {
        requireRequest().complete();
    }

    public void addRequestComment(String text) {
        requireLogin();
        requireRequest().addComment(new RequestComment(currentUser, text));
    }

    public ArrayList<RequestComment> getRequestComments() {
        return requireRequest().getComments();
    }

    public ArrayList<ReliefRequest> listOpenRequests() {
        return reliefManagement.getRequestsByStatus(ReliefRequestStatus.SUBMITTED);
    }

    public ArrayList<ReliefRequest> listRequestsByRegion(UUID regionId) {
        return reliefManagement.getRequestsByRegion(regionId);
    }

    // ---------- shelters ----------

    public Shelter findSafeShelter(Location location, int people) {
        Shelter best = null;
        double bestDistance = Double.MAX_VALUE;
        for (Shelter s : shelterManagement.getAvailableShelters(people)) {
            Location a = s.getAddress();
            double dLat = a.getLatitude() - location.getLatitude();
            double dLon = a.getLongitude() - location.getLongitude();
            double distance = dLat * dLat + dLon * dLon;
            if (distance < bestDistance) {
                bestDistance = distance;
                best = s;
            }
        }
        return best;
    }

    public Shelter selectShelter(UUID shelterId) {
        Shelter shelter = shelterManagement.getShelter(shelterId);
        if (shelter == null) {
            throw new IllegalArgumentException("No shelter with id " + shelterId);
        }
        currentShelter = shelter;
        return shelter;
    }

    //Q: Set this
    public void assignShelterToRequest(UUID shelterId) {
        ReliefRequest request = requireRequest();
        request.setDestinationShelter(selectShelter(shelterId));
    }

    public void checkInCitizen(String qrCode) {
        requireShelter().checkIn(qrCode);
    }

    public void checkOutCitizen(UUID citizenId) {
        requireShelter().checkOut(citizenId.toString());
    }

    public void updateShelterInventory(ShelterResource resource) {
        requireShelter().updateInventory(resource);
    }

    public ArrayList<ShelterResource> getLowStockResources() {
        ArrayList<ShelterResource> low = new ArrayList<>();
        for (ShelterResource r : requireShelter().getResources()) {
            if (r.checkStockLevel()) {      // true means stock is low
                low.add(r);
            }
        }
        return low;
    }

    public void changeShelterStatus(String status) {
        requireShelter().setOperationalStatus(status);
    }

    // ---------- hazards ----------

    public HazardReport reportHazard(HazardCategory type, Location location) {
        requireLogin();
        HazardReport report = new HazardReport(type, location, currentUser.getUserName());
        report.report();
        hazards.add(report);
        return report;
    }

    public void verifyHazard(UUID hazardId) {
        for (HazardReport h : hazards) {
            if (h.getId().equals(hazardId)) {
                h.verify();
                return;
            }
        }
        throw new IllegalArgumentException("No hazard with id " + hazardId);
    }

    public ArrayList<HazardReport> listVerifiedHazards() {
        ArrayList<HazardReport> verified = new ArrayList<>();
        for (HazardReport h : hazards) {
            if (h.isVerified()) {
                verified.add(h);
            }
        }
        return verified;
    }

    // ---------- regions and hurricane events ----------

    public void setEvacuationStatus(UUID regionId, ZoneType zoneType) {
        for (GeographicRegion r : regions) {
            if (r.getId().equals(regionId)) {
                r.setZoneType(zoneType);
                return;
            }
        }
        throw new IllegalArgumentException("No region with id " + regionId);
    }

    public void updateHurricaneTrack(String eventName) {
        HurricaneEvent event = eventManagement.getEvent(eventName);
        if (event == null) {
            throw new IllegalArgumentException("No event named " + eventName);
        }
        event.updateTrack();
    }

    public HurricaneEvent getActiveEvent() {
        return eventManagement.getActiveEvent();
    }

    // ---------- admin actions (all require an Admin to be signed in) ----------

    public void approveRequest() {
        requireAdmin().approve(requireRequest());
    }

    public void denyRequest() {
        requireAdmin().deny(requireRequest());
    }

    public void archiveRequest() {
        requireAdmin().archiveRequest(requireRequest());
    }

    public void overrideUserRole(UUID userId, UserRole role) {
        User target = userManagement.getUser(userId);
        if (target == null) {
            throw new IllegalArgumentException("No user with id " + userId);
        }
        requireAdmin().overrideRole(target, role);
    }

    public void banUser(UUID userId) {
        User target = userManagement.getUser(userId);
        if (target == null) {
            throw new IllegalArgumentException("No user with id " + userId);
        }
        requireAdmin().banUser(target);
    }

    public void notifyResponders() {
        // Q: Placeholder -message every Helper near currentRequest
        requireRequest();
    }

    public void publishEmergencyAlert(String message) {
        requireAdmin().broadcastAlert(message);
    }
}
