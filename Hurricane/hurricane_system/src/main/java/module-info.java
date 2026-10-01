module com.relief_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.relief_system to javafx.fxml;
    exports com.relief_system;

    opens com.model to javafx.fxml;
    exports com.model;

}