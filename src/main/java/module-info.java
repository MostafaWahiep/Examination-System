module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ExaminationSystem to javafx.fxml;
    exports com.example.ExaminationSystem;
}