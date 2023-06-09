package com.example.ExaminationSystem;

import com.example.ExaminationSystem.Models.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddCourseController {

    @FXML
    private TextField courseIDField;

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TableColumn<Course, String> idCol;

    @FXML
    private TableColumn<Course, String> nameCol;

    @FXML
    private TableColumn<Course, String> codeCol;

    @FXML
    private TableColumn<Course, String> instructorCol;

    private ArrayList<Course> courses;

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    private Course findCourseByID(String id) {
        for (Course c : Main.courses) {
            if (c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @FXML
    private void addCourse() {
        String id = courseIDField.getText();
        Course course = findCourseByID(id);
        if (course != null) {
            courseTable.getItems().add(course);
        }
    }

    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        instructorCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getInstructor().getName()));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Main.UserType = 0;
        Parent root1 = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
        Stage appst = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
}


