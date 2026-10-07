package com.model;

import java.util.ArrayList;

public class ShelterManagement {
    private static ShelterManagement shelterManagement;
    private ArrayList<Shelter> shelters;

    private ShelterManagement(){
        shelters = new ArrayList<>();
    }

    public static ShelterManagement getInstance(){
        return shelterManagement;
    }

    public ArrayList<Shelter> getShelters(){
        return shelters;
    }

    public Shelter getShelter(String id){
        for (Shelter s: shelters){
            if (s.getID().equals(id)){
                return s;
            }
        }
        return null;
    }

    public ArrayList<Shelter> getAvailableShelters(int people){
        ArrayList<Shelter> available = new ArrayList<>();

        for (Shelter s: shelters){
            int openSpots = (s.getCapacity() - s.getOccupancy());

            if (openSpots >= people) {
                available.add(s);
            }

        }
        return available;
    }

    public void addShelter(Shelter shelter){
        shelters.add(shelter);
    }

    public void removeShelter(String id){
        shelters.removeIf(shelter -> shelter.getId().equals(id));
    }
}
