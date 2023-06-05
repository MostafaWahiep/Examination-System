package com.example.ExaminationSystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SendFeedbackPageController extends Application {


@FXML
    void GotoInstructorMain(ActionEvent event)throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("InstructorMainPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    @FXML
    void SubmitFeedBack(ActionEvent event)throws IOException {
    }

    @FXML
    void ViewGrade(ActionEvent event)throws IOException {
    }
    @Override
    public void start(Stage primaryStage) {

    }
}
