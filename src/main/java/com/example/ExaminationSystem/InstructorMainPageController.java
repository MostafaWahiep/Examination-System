package com.example.ExaminationSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InstructorMainPageController {
    @FXML
    private Label profl;
    @FXML
    private ComboBox<String> List;


    @FXML
    private Label profname;

    @FXML
    private Button reportb;

    @FXML
    private Label reportl;

    @FXML
    private Button returnb;

    @FXML
    private Button setexamb;

    @FXML
    private Label setexaml;

    @FXML
    void reportb(ActionEvent event)throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource("ReportPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    public void backk(ActionEvent event) throws IOException {
        Main.us = 0;
        Parent root1 = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    @FXML
    void returnpage(ActionEvent event) throws IOException{
  //switch to the previous page

    }

    @FXML
    void setexamb(ActionEvent event) throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource("SetExamPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }


    public void initialize() {

        profname.setText(""); //get instructor name
        List.getItems().add(" "); //looping on number of courses and adding them
    }

}
