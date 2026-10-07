package com.model;
import java.time.LocalDateTime;
import java.util.UUID;


public class HazardReport {
    private UUID id;
    private HazardCategory type;
    private Location location;
    private boolean verified;
    private String source;
    private DateTime timeStamp;

    public HazardReport(HazardCategory type, Location location, String source){
        //Q: Added UUID to UML because we need instance
        this.id = UUID.randomUUID();
        this.type = type;
        this.location = location;
        this.source = source;
        this.verified = false;
        // this.timeStamp = LocalDateTime.now(); //Q: Will be fixed once we figure out whether we're using DateTime or LocalDateTime
    }
    public HazardReport(HazardCategory type, Location location, boolean verified, String source, DateTime timeStamp){
        this.id = UUID.randomUUID;
        this.type = type;
        this.location = location;
        this.verified = verified;
        this.source = source;
        this.timeStamp = timeStamp;
    }
    
    public void report(){
        //Q: Not entirely sure what should go in here
        //Q: time reported? Summary of whole report?
    }

    public void verify(){
        this.verified = true;
    }
}
