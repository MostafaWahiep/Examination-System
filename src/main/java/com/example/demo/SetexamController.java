package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SetexamController {
    Exam exam;
    ObservableList<String> courseList = FXCollections.observableArrayList();
    @FXML
    private TextField startTime;
    @FXML
    private TextField endTime;
    @FXML
    private TextField duration;
    @FXML
    private Label Mark;
    @FXML
    private TextField Question;
    @FXML
    private TextField firstAnswer;
    @FXML
    private TextField secondAnswer;
    @FXML
    private TextField thirdAnswer;
    @FXML
    private TextField fourthAnswer;
    @FXML
    private TextField correctAnswer;
    @FXML
    private TextField Grade;
    @FXML
    private DatePicker Date;
    @FXML
    private ChoiceBox Course;
    @FXML
    private void initialize(){
        for(Course c:HelloApplication.courses)
            courseList.add(c.getName());
        Course.setItems(courseList);
    }
    @FXML
    private void create(){
        Course c = HelloApplication.courses.get(Course.getSelectionModel().getSelectedIndex());
        System.out.println(c.getCourse_code());
        exam= new Exam(c,new Float(duration.getText()), new Float(startTime.getText()), new Float(endTime.getText()), Date.getValue().toString());
        HelloApplication.exams.add(exam);
        Histogram histo = new Histogram(exam);
        Exam_Report exam_report = new Exam_Report(exam, histo);
        exam.setExam_report(exam_report);
    }
    @FXML
    void returnb(ActionEvent event) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("instmain.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
    @FXML
    private void addquestion(){
        String[] choices = new String[4];
        choices[0] = firstAnswer.getText();
        choices[1] = secondAnswer.getText();
        choices[2] = thirdAnswer.getText();
        choices[3] = fourthAnswer.getText();
        Question q = new Question(Question.getText(), choices, correctAnswer.getText().charAt(0), new Integer(Grade.getText()));
        exam.addquestoin(q);
        Mark.setText("Mark = " + exam.getMark());
        firstAnswer.setText("");
        secondAnswer.setText("");
        thirdAnswer.setText("");
        fourthAnswer.setText("");
        Question.setText("");
        correctAnswer.setText("");
        Grade.setText("");
    }
}