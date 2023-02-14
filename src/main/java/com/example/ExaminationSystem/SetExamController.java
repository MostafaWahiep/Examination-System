package com.example.ExaminationSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SetExamController {
    Exam exam;
    ObservableList<String> courseList = FXCollections.observableArrayList();
    @FXML
    private TreeView<String> DisplayQuestons;
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
    private Tab AddedQuestionsTab;
    @FXML
    private Tab SetExamTab;
    @FXML
    private void initialize(){
        for(Course c: Main.courses)
            courseList.add(c.getName());
        Course.setItems(courseList);
        AddQuestionsTab();
    }
    @FXML
    private void create(){
        Course c = Main.courses.get(Course.getSelectionModel().getSelectedIndex());
        System.out.println(c.getCourse_code());
        exam= new Exam(c,new Float(duration.getText()), new Float(startTime.getText()), new Float(endTime.getText()), Date.getValue().toString());
        Main.exams.add(exam);
        Histogram histo = new Histogram(exam);
        ExamReport exam_report = new ExamReport(exam, histo);
        exam.setExam_report(exam_report);
    }
    @FXML
    void returnb(ActionEvent event) throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("InstructorMainPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();
    }
    @FXML
    private void addquestion()
    {
        String[] choices = new String[4];
        choices[0] = firstAnswer.getText();
        choices[1] = secondAnswer.getText();
        choices[2] = thirdAnswer.getText();
        choices[3] = fourthAnswer.getText();
        Question q = new Question(Question.getText(), choices, correctAnswer.getText().charAt(0), new Integer(Grade.getText()));
        exam.addquestion(q);
        Mark.setText("Mark = " + exam.getMark());
        firstAnswer.setText("");
        secondAnswer.setText("");
        thirdAnswer.setText("");
        fourthAnswer.setText("");
        Question.setText("");
        correctAnswer.setText("");
        Grade.setText("");
        AddQuestionsTab();
    }

    void AddQuestionsTab()
    {

        TreeItem<String> dummyroot=new TreeItem<>(" ");
        for(int i=0;i<Main.exams.get(0).getNum_of_questions();i++)
        {
            TreeItem<String> Root=new TreeItem<>(Main.exams.get(0).getQuestions()[i].getName());
            TreeItem<String> Choice1=new TreeItem<>("a. " + Main.exams.get(0).getQuestions()[i].getChoices(0));
            TreeItem<String> Choice2=new TreeItem<>("b. " + Main.exams.get(0).getQuestions()[i].getChoices(1));
            TreeItem<String> Choice3=new TreeItem<>("c. " + Main.exams.get(0).getQuestions()[i].getChoices(2));
            TreeItem<String> Choice4=new TreeItem<>("d. " + Main.exams.get(0).getQuestions()[i].getChoices(3));
            TreeItem<String> Grade=new TreeItem<>("Grade: "+ Integer.toString(Main.exams.get(0).getQuestions()[i].getGrade()));
            TreeItem<String> CorrectChoice=new TreeItem<>("CorrectChoice: " + String.valueOf(Main.exams.get(0).getQuestions()[i].getCorrect_choice()));
            Root.getChildren().addAll(Choice1,Choice2,Choice3,Choice4,Grade, CorrectChoice);

            Root.setExpanded(true);
            dummyroot.getChildren().addAll(Root);
        }
        DisplayQuestons.setRoot(dummyroot);
        DisplayQuestons.setShowRoot(false);

    }
}