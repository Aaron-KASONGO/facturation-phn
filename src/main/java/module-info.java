module com.example.facturation_phn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.facturation_phn to javafx.fxml;
    exports com.example.facturation_phn;
}