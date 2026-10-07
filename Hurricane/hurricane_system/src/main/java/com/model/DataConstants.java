import java.io.File;

public abstract class DataConstants{

    protected static final String USER_FILE_NAME = "json" + File.separator + "User.json";
    protected static final String SHELTER_FILE_NAME = "json" + File.separator + "Shelter.json";
    protected static final String RELIEF_REQUEST_FILE_NAME = "json" + File.separator + "relief_requests.json";
    protected static final String REGION_FILE_NAME = "json" + File.separator + "regions.json";
    protected static final String HAZARD_FILE_NAME = "json" + File.separator + "hazards.json";
    protected static final String EVENT_FILE_NAME = "json" + File.separator + "events.json";
    protected static final String LOCATION_FILE_NAME = "json" + File.separator + "locations.json";

    protected static final String USER_ID = "id";
    protected static final String USER_USERNAME = "userName";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_AGE = "age";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_ROLES = "roles";

    protected static final String SHELTER_ID = "id";
    protected static final String SHELTER_NAME = "name";
    protected static final String SHELTER_CAPACITY = "capacity";
    protected static final String SHELTER_OCCUPANCY = "currentOccupancy";

    protected static final String RELIEF_REQUEST_ID = "id";
    protected static final String RELIEF_REQUEST_ASSISTANCE = "assistance";
    protected static final String RELIEF_REQUEST_PEOPLE = "people";
    protected static final String RELIEF_REQUEST_STATUS = "status";

}