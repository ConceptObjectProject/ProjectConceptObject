module org.isen.conceptObject {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.isen.conceptObject to javafx.fxml;
    exports org.isen.conceptObject;
}