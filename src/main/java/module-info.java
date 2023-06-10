module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires junit4;
    requires org.testfx;
    requires org.testfx.junit5;
    requires org.junit.jupiter.api;
    requires org.mockito;
    requires org.mockito.junit.jupiter;


    opens com.example.ExaminationSystem to javafx.fxml;
    exports com.example.ExaminationSystem;
    exports com.example.ExaminationSystem.Models;
    exports com.example.ExaminationSystem.Tests;
    opens com.example.ExaminationSystem.Models to javafx.fxml;
    opens com.example.ExaminationSystem.Tests to javafx.fxml;
}