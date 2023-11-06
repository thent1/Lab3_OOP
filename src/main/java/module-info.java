module com.example.lab3_oop {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.lab3_oop to javafx.fxml;
    exports com.example.lab3_oop;
}