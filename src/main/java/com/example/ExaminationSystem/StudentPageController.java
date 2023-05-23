package com.example.ExaminationSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {

    @FXML
    private TableColumn<Exam, String> course;

    @FXML
    private Button addCourse;

    @FXML
    private TableColumn<Exam, Float> duration;

    @FXML
    private TableColumn<Exam, Float> endtime;

    @FXML
    private TableColumn<Exam, Integer> examID;

    @FXML
    private TableColumn<Exam, Integer> numofque;

    @FXML
    private Button returnb;

    @FXML
    private TableColumn<Exam, Float> starttime;

    @FXML
    private TableView<Exam> table;

    @FXML
    void returnb(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Main.UserType = 0;
        Parent root1 = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Stage appst = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Exam> ex = FXCollections.observableArrayList();
        for (Exam e : Main.exams)
            ex.add(e);
        examID.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("ID"));
        course.setCellValueFactory(new PropertyValueFactory<Exam, String>("course"));
        starttime.setCellValueFactory(new PropertyValueFactory<Exam, Float>("startTime"));
        endtime.setCellValueFactory(new PropertyValueFactory<Exam, Float>("endTime"));
        duration.setCellValueFactory(new PropertyValueFactory<Exam, Float>("duration"));
        numofque.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("num_of_questions"));
        table.setItems(ex);

    }

    @FXML
    public void enter(ActionEvent event) throws IOException {
        if (table.getSelectionModel().isEmpty() == false) {
            Main.toexam = table.getSelectionModel().getSelectedItem();
            Parent root1 = FXMLLoader.load(getClass().getResource("HaveExamPage.fxml"));
            Stage appst = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root1);
            appst.setScene(scene1);
            appst.show();

        }
    }

    @FXML
    public void AddCourse(ActionEvent event) throws IOException {

            Parent root1 = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
            Stage appst = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root1);
            appst.setScene(scene1);
            appst.show();
        }
    }

