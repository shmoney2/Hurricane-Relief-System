package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

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
                int occupancy = (int) (long) shelterJSON.get(SHELTER_OCCUPANCY);

                boolean petFriendly = (Boolean) shelterJSON.get(SHELTER_PET_FRIENDLY);
                boolean accessible = Boolean.TRUE.equals(shelterJSON.get(SHELTER_ACCESSIBLE));
                boolean medicalStaff = Boolean.TRUE.equals(shelterJSON.get(SHELTER_MEDICAL_STAFF));
                boolean vetStaff = Boolean.TRUE.equals(shelterJSON.get(SHELTER_VET_STAFF));

                String operationalStatus = (String) shelterJSON.get(SHELTER_OPERATIONAL_STATUS);

                JSONObject locationJSON = (JSONObject) shelterJSON.get(SHELTER_LOCATION);
                Location address = null;
                if (locationJSON != null) {
                    UUID locId = UUID.fromString((String) locationJSON.get("id"));
                    String street1 = (String) locationJSON.get("street1");
                    String street2 = (String) locationJSON.get("street2");
                    String city = (String) locationJSON.get("city");
                    String state = (String) locationJSON.get("state");
                    String zipCode = (String) locationJSON.get("zipCode");
                    double latitude = (Double) locationJSON.get("latitude");
                    double longitude = (Double) locationJSON.get("longitude");

                    address = new Location(locId, street1, street2, city, state, zipCode, latitude, longitude);
                }

                // Construct Shelter Object
                Shelter shelter = new Shelter(
                    id, name, address, capacity, occupancy, 
                    petFriendly, accessible, medicalStaff, vetStaff, operationalStatus
                );

                shelters.add(shelter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return shelters;
    }
        public static void main(String[] args) {
        System.out.println("--- Testing DataLoader.getShelters() ---");
        
        // Call the static method to load shelters from JSON
        ArrayList<Shelter> shelters = DataLoader.getShelters();

        if (shelters.isEmpty()) {
            System.out.println("No shelters loaded. Please check that 'shelters.json' exists in the json folder and contains valid JSON.");
        } else {
            System.out.println("Successfully loaded " + shelters.size() + " shelter(s):\n");
            
            for (Shelter shelter : shelters) {
                // Prints using Shelter's toString() method
                System.out.println(shelter); 
                System.out.println("----------------------------------------");
            }
        }
    }

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

                users.add(new User(id, userName, firstName, lastName, password, location));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

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
