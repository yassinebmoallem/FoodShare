module com.example.FoodShare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.FoodShare to javafx.fxml;
    exports com.example.FoodShare;
}