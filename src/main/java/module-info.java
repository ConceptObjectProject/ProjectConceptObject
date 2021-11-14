module org.isen.conceptObject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    opens org.isen.conceptObject to javafx.fxml;
    exports org.isen.conceptObject;
    exports org.isen.conceptObject.controller;
    opens org.isen.conceptObject.controller to javafx.fxml;
}