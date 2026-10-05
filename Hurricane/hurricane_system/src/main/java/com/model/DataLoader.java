package Hurricane.hurricane_system.src.main.java.com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public static ArrayList<Shelter> getShelters(){
        ArrayList<Shelter> shelters = new ArrayList<>();

        try{
            FileReader reader = new FileReader("json/Shelters.json");

            JSONParser parser = new JSONParser();
            JSONArray sheltersJSON = (JSONArray) parser.parse(reader);
            for (int i = 0; i < sheltersJSON.size(); i++) {
                JSONObject shelterJSON = (JSONObject) sheltersJSON.get(i);

                String idString = (String) shelterJSON.get(SHELTER_ID);
                UUID id = UUID.fromString(idString);

                String name = (String) shelterJSON.get(SHELTER_NAME);

                long capacityLong = (Long) shelterJSON.get(SHELTER_CAPACITY);
                int capacity = (int) capacityLong;

                long occupancyLong = (Long) shelterJSON.get(SHELTER_OCCUPANCY);
                int currentOccupancy = (int) occupancyLong;

                Shelter shelter = new Shelter(id, name, capacity, currentOccupancy);
                shelters.add(shelter);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        }
    }
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        return users;
    }

    public static ArrayList<ReliefRequest> getReliefRequests() {
        ArrayList<ReliefRequest> requests = new ArrayList<>();
        return requests;
    }

    public static ArrayList<GeographicRegion> getGeographicRegions() {
        ArrayList<GeographicRegion> regions = new ArrayList<>();
        return regions;
    }

    public static ArrayList<HurricaneEvent> getHurricaneEvents() {
        ArrayList<HurricaneEvent> events = new ArrayList<>();
        return events;
    }

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        return locations;
    }

}
