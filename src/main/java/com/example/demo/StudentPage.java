package com.example.demo;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentPage implements Initializable {

    @FXML
    private TableColumn<Exam, String> course;

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
        HelloApplication.us = 0;
        Parent root1 = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Exam> ex = FXCollections.observableArrayList();
        for (Exam e:HelloApplication.exams)
            ex.add(e);
        examID.setCellValueFactory(new PropertyValueFactory<Exam,Integer>("ID"));
        course.setCellValueFactory(new PropertyValueFactory<Exam,String>("course"));
        duration.setCellValueFactory(new PropertyValueFactory<Exam,Float>("duration"));
        endtime.setCellValueFactory(new PropertyValueFactory<Exam,Float>("endtime"));
        starttime.setCellValueFactory(new PropertyValueFactory<Exam,Float>("starttime"));
        numofque.setCellValueFactory(new PropertyValueFactory<Exam,Integer>("num_of_questions"));
        table.setItems(ex);

    }
    @FXML
    public void enter(ActionEvent event) throws IOException{
        if(table.getSelectionModel().isEmpty()== false)
        {
            HelloApplication.toexam = table.getSelectionModel().getSelectedItem();
            Parent root1 = FXMLLoader.load(getClass().getResource("haveexam.fxml"));
            Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root1);
            appst.setScene(scene1);
            appst.show();

        }
    }
}
