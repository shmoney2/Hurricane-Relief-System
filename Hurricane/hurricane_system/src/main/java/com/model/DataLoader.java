package Hurricane.hurricane_system.src.main.java.com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    // 1. SHELTERS (Intermediate)
    public static ArrayList<Shelter> getShelters() {
        ArrayList<Shelter> shelters = new ArrayList<>();

        try {
            FileReader reader = new FileReader(SHELTER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray sheltersJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < sheltersJSON.size(); i++) {
                JSONObject shelterJSON = (JSONObject) sheltersJSON.get(i);

                UUID id = UUID.fromString((String) shelterJSON.get(SHELTER_ID));
                String name = (String) shelterJSON.get(SHELTER_NAME);
                int capacity = (int) (long) shelterJSON.get(SHELTER_CAPACITY);
                int currentOccupancy = (int) (long) shelterJSON.get(SHELTER_OCCUPANCY);

                shelters.add(new Shelter(id, name, capacity, currentOccupancy));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shelters;
    }

    // 2. USERS (Intermediate - Handles Array of Strings)
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject) usersJSON.get(i);

                UUID id = UUID.fromString((String) userJSON.get(USER_ID));
                String userName = (String) userJSON.get(USER_USERNAME);
                String firstName = (String) userJSON.get(USER_FIRST_NAME);
                String lastName = (String) userJSON.get(USER_LAST_NAME);
                int age = (int) (long) userJSON.get(USER_AGE);
                String password = (String) userJSON.get(USER_PASSWORD);

                // Parsing array of roles
                JSONArray rolesJSONArray = (JSONArray) userJSON.get(USER_ROLES);
                ArrayList<String> roles = new ArrayList<>();
                if (rolesJSONArray != null) {
                    for (int j = 0; j < rolesJSONArray.size(); j++) {
                        roles.add((String) rolesJSONArray.get(j));
                    }
                }

                users.add(new User(id, userName, firstName, lastName, age, password, roles));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    // 3. RELIEF REQUESTS (Hard - Parses Enums and Object References)
    public static ArrayList<ReliefRequest> getReliefRequests() {
        ArrayList<ReliefRequest> requests = new ArrayList<>();

        try {
            FileReader reader = new FileReader(RELIEF_REQUEST_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray requestsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < requestsJSON.size(); i++) {
                JSONObject requestJSON = (JSONObject) requestsJSON.get(i);

                UUID id = UUID.fromString((String) requestJSON.get(RELIEF_REQUEST_ID));
                String assistance = (String) requestJSON.get(RELIEF_REQUEST_ASSISTANCE);
                int people = (int) (long) requestJSON.get(RELIEF_REQUEST_PEOPLE);

                // Converting String from JSON into Enum values
                String statusStr = (String) requestJSON.get(RELIEF_REQUEST_STATUS);
                ReliefRequestStatus status = ReliefRequestStatus.valueOf(statusStr);

                // If JSON includes Enum for urgency:
                // String urgencyStr = (String) requestJSON.get("urgency");
                // UrgencyTier urgency = UrgencyTier.valueOf(urgencyStr);

                requests.add(new ReliefRequest(id, assistance, people, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return requests;
    }

    // 4. LOCATIONS (Easy)
    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        try {
            FileReader reader = new FileReader(LOCATION_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray locationsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < locationsJSON.size(); i++) {
                JSONObject locationJSON = (JSONObject) locationsJSON.get(i);

                String address = (String) locationJSON.get("address");
                double latitude = (double) locationJSON.get("latitude");
                double longitude = (double) locationJSON.get("longitude");

                locations.add(new Location(address, latitude, longitude));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations;
    }

    // 5. GEOGRAPHIC REGIONS (Easy)
    public static ArrayList<GeographicRegion> getGeographicRegions() {
        ArrayList<GeographicRegion> regions = new ArrayList<>();

        try {
            FileReader reader = new FileReader(REGION_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray regionsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < regionsJSON.size(); i++) {
                JSONObject regionJSON = (JSONObject) regionsJSON.get(i);

                String name = (String) regionJSON.get("name");
                regions.add(new GeographicRegion(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return regions;
    }

    // 6. HURRICANE EVENTS (Easy)
    public static ArrayList<HurricaneEvent> getHurricaneEvents() {
        ArrayList<HurricaneEvent> events = new ArrayList<>();

        try {
            FileReader reader = new FileReader(EVENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray eventsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < eventsJSON.size(); i++) {
                JSONObject eventJSON = (JSONObject) eventsJSON.get(i);

                String name = (String) eventJSON.get("name");
                events.add(new HurricaneEvent(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }
}
