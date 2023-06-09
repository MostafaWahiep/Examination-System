module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires junit4;


    opens com.example.ExaminationSystem to javafx.fxml;
    exports com.example.ExaminationSystem;
    exports com.example.ExaminationSystem.Models;
    exports com.example.ExaminationSystem.Tests;
    opens com.example.ExaminationSystem.Models to javafx.fxml;
}