package com.model;

import java.time.LocalDateTime;

public class HurricaneEvent {
    private String name;
    private int category;
    private Location location;
    private float windSpeed;
    private String direction;
    private String path;
    private LocalDateTime estimatedArrivalTime;

    public HurricaneEvent(String name, int category, Location location){
        this.name = name;
        this.category = category;
        this.location = location;
    }

    public HurricaneEvent(String name, int category, Location location, String direction){
    this.name = name;
    this.category = category;
    this.location = location;
    this.direction = direction;
    }

    public HurricaneEvent(String name, int category, Location location, float windSpeed, String direction, String path, LocalDateTime estimatedArrivalTime){
    this.name = name;
    this.category = category;
    this.location = location;
    this.windSpeed = windSpeed;
    this.direction = direction;
    this.path = path;
    this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public void updateTrack(Location location, String direction, String path){
        this.location = location;
        this.direction = direction;
        this.path = path;
    }

    public String getName() { return name; }
    public int getCategory() { return category; }
    public Location getLocation() { return location; }
    public float getWindSpeed() { return windSpeed; }
    public String getDirection() { return direction; }
    public String getPath() { return path; }
    public LocalDateTime getEstimatedArrivalTime() { return estimatedArrivalTime; }

    public void setLocation(Location location) { this.location = location; }
    public void setWindSpeed(float windSpeed) { this.windSpeed = windSpeed; }
    public void setDirection(String direction) { this.direction = direction; }
    public void setPath(String path) { this.path = path; }
    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
    this.estimatedArrivalTime = estimatedArrivalTime; }

}
