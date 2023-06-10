package com.example.ExaminationSystem;

import com.example.ExaminationSystem.Models.ExamAttempt;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SendFeedbackPageController implements Initializable {

    @FXML
    private TableColumn<ExamAttempt, String> course_code;

    @FXML
    private TableColumn<ExamAttempt, Integer> exam_id;

    @FXML
    private TextArea feedback_text;

    @FXML
    private TableColumn<ExamAttempt, Integer> grade;

    @FXML
    private TableColumn<ExamAttempt, Integer> num_answered;

    @FXML
    private TableColumn<ExamAttempt, Integer> num_correct;

    @FXML
    private TableColumn<ExamAttempt, Integer> num_questions;

    @FXML
    private TableColumn<ExamAttempt, String> student_name;

    @FXML
    private TableView<ExamAttempt> table;

    @FXML
    private Label errorLabel;

    @FXML
    void GotoInstructorMain(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("InstructorMainPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }

    @FXML
    void selectexamattempt() {
        errorLabel.setText("");
        ExamAttempt examAttempt = table.getSelectionModel().getSelectedItem();
        if (examAttempt == null || examAttempt.getFeedback() == null) {
            return;
        }
        else {
            feedback_text.setText(examAttempt.getFeedback());
        }
    }


    @FXML
    void SubmitFeedBack( ActionEvent event){
        ExamAttempt examAttempt = table.getSelectionModel().getSelectedItem();
        if (examAttempt == null) {
            errorLabel.setText("Please select an exam attempt");
        }
        else {
            examAttempt.setFeedback(feedback_text.getText());
            feedback_text.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // add exam attempts to table
        ObservableList<ExamAttempt> examAttempts = FXCollections.observableArrayList();
        for (ExamAttempt examAttempt : Main.examAttempts)
            examAttempts.add(examAttempt);

        student_name.setCellValueFactory(new PropertyValueFactory<ExamAttempt, String>("student"));
        course_code.setCellValueFactory(new PropertyValueFactory<ExamAttempt, String>("course"));
        exam_id.setCellValueFactory(new PropertyValueFactory<ExamAttempt, Integer>("exam"));
        grade.setCellValueFactory(new PropertyValueFactory<ExamAttempt, Integer>("grade"));
        num_questions.setCellValueFactory(new PropertyValueFactory<ExamAttempt, Integer>("num_questions"));
        num_answered.setCellValueFactory(new PropertyValueFactory<ExamAttempt, Integer>("answered_questions"));
        num_correct.setCellValueFactory(new PropertyValueFactory<ExamAttempt, Integer>("correct_answers"));
        table.setItems(examAttempts);
    }

}