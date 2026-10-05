package com.model;
import java.io.FileWriter;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Hurricane.hurricane_system.src.main.java.com.model.Shelter;
/**
 * Tell Anish to fix all stub fields, Dataloader + Datawriter cannot run without them being fixed.
 * //Location, ShelterResource, and DateTime need to be fixed no fields, no getters.
 * //Shelter.java's constructors are empty
 * //Shelter.json also needs to be fixed, variables are not matching shelters.json
 * //This code can only be temporaroily run if you comment out the lines in DataLoader.java and DataWriter.java that use these classes.
 * //This code is not runnable in its current state, it will throw errors if you try to run it.
 * //Untested and likely needs to be fixed, but this is the best I can do with the current state of the code.
 * @author Sahil
 */
public class DataWriter  {
    public static void saveShelters(ArrayList<Shelter> shelters) {
        JSONArray sheltersJSON = new JSONArray();

    for (Shelter shelter : shelters) {
            sheltersJSON.add(getShelterJSON(shelter));
        }
 
        try {
            FileWriter rider = new FileWriter(Shelter);
            rider.write(sheltersJSON.toJSONString());
            rider.flush();
            rider.close();
        } catch (Exception e) {
            System.err.println("Could not save shelters: " + e.getMessage());
        }
    }
/**
 * I am very unsure about this code, it is likely broken and needs to be fixed. I am not sure what the correct implementation should be, but this is the best I can do with the current state of the code.
 * @param shelter
 * @return
 */
    public static JSONObject getShelterJSON(Shelter shelter) {
        JSONObject shelterJSON = new JSONObject();
 
        shelterJSON.put(SHELTER_ID, shelter.getId().toString());
        shelterJSON.put(SHELTER_NAME, shelter.getName());
        shelterJSON.put(SHELTER_ADDRESS, getLocationJSON(shelter.getAddress()));
        shelterJSON.put(SHELTER_CAPACITY, shelter.getCapacity());
        shelterJSON.put(SHELTER_OCCUPANCY, shelter.getOccupancy());
        shelterJSON.put(SHELTER_PET_FRIENDLY, shelter.isPetFriendly());
        shelterJSON.put(SHELTER_ACCESSIBLE, shelter.isAccessible());
        shelterJSON.put(SHELTER_MEDICAL_STAFF, shelter.hasMedicalStaff());
        shelterJSON.put(SHELTER_VET_STAFF, shelter.hasVetStaff());  //I am unsure about this line are we including this??? It is in our json
        shelterJSON.put(SHELTER_OPERATIONAL_STATUS, shelter.getOperationalStatus());
 
        JSONArray resourcesJSON = new JSONArray();
        for (ShelterResource resource : shelter.getResources()) {
            resourcesJSON.add(getResourceJSON(resource));
        }
        shelterJSON.put(SHELTER_RESOURCES, resourcesJSON);
 
        return shelterJSON;
    }
    /**
     * There are more methods that need to be implementd, but I want to check structure for just these for bnow
     * 
     * 
     */
 
}
