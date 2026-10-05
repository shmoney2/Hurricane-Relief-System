package com.model;

import java.util.UUID;

public class GeographicRegion {
    private UUID id;
    private String name;
    private String boundary;
    private ZoneType zoneType;
    private String evacuationStatus;

    public void GeographicRegion(String name, String boundary){
        this.id = UUID.randomUUID();
        this.name = name;
        this.boundary = boundary;
        //Q: Should I make the other instance variables = null or are they fine being auto set to null?
    }

    public void GoegraphicRegion(String name, String boundary, ZoneType zoneType, String evacuationStatus){
        this.name = name;
        this.boundary = boundary;
        this.zoneType = zoneType;
        this.evacuationStatus = evacuationStatus;
    }

    public void drawBoundary(String coordinates){
        this.boundary = coordinates;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public ZoneType getZoneType() { return zoneType; }
    public void setZoneType(ZoneType zoneType) { this.zoneType = zoneType; }

}
