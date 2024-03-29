package com.example.ExaminationSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ExaminationSystem.Models.ExamAttempt;
import com.example.ExaminationSystem.Models.Student;


import java.time.LocalDate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HaveExamPageController implements Initializable {
    Integer[] Questions;
    char[] ans;
    Integer at = 0;
    int x;
    @FXML
    private RadioButton c1;

    @FXML
    private RadioButton c2;

    @FXML
    private RadioButton c3;

    @FXML
    private RadioButton c4;

    @FXML
    private ToggleGroup gg;

    @FXML
    private Label qname;

    @FXML
    private ListView<Integer> list;
    @FXML
    private Button ret;
    @FXML
    private Label gradeee;
    @FXML
    private Button finish;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        x = Main.toexam.getNum_of_questions();
        ans = new char[x];
        Questions = new Integer[x];
        for(int i = 0; i < x; i++)
            Questions[i] = i +1 ;
        list.getItems().addAll(Questions);
        setquestion(0);
        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
        at = 0;
    }

    @FXML
    public void changequestion(){
        if(c1.isSelected())
            ans[at]='a';
        else if(c2.isSelected())
            ans[at]='b';
        else if(c3.isSelected())
            ans[at]='c';
        else if(c4.isSelected())
            ans[at]='d';
        at = list.getSelectionModel().getSelectedItem() - 1;
        setquestion(at);
        if(ans[at] == 'a')
            c1.setSelected(true);
        else if(ans[at] == 'b')
            c2.setSelected(true);
        else if(ans[at] == 'c')
            c3.setSelected(true);
        else if(ans[at] == 'd')
            c4.setSelected(true);
        else {
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
        }
    }
    public void finish(){
        int grade = 0;
        if(c1.isSelected())
            ans[at]='a';
        else if(c2.isSelected())
            ans[at]='b';
        else if(c3.isSelected())
            ans[at]='c';
        else if(c4.isSelected())
            ans[at]='d';
        int answered = 0, correct = 0;
        for(int i = 0; i < x; i++)
        {
            if(ans[i] != 0)
                answered++;
            int s = Main.toexam.getQuestions()[i].check_ans(ans[i]);
            if(s > 1)
                correct++;
            grade += s;
        }
        gradeee.setText("your grade is " + grade + " out of " + Main.toexam.getMark());
        Main.toexam.getExam_report().getHisto().addgrade(grade);

        // attempt with today's date
        Main.examAttempts.add(new ExamAttempt((Student) Main.CurrentUser, Main.toexam, LocalDate.now().toString() , grade, answered, correct));

        c1.setDisable(true);
        c2.setDisable(true);
        c3.setDisable(true);
        c4.setDisable(true);
        finish.setDisable(true);
    }
    private void setquestion(Integer i){
        qname.setText(Main.toexam.getQuestions()[i].getName());
        c1.setText("a " + Main.toexam.getQuestions()[i].getChoices(0));
        c2.setText("b " + Main.toexam.getQuestions()[i].getChoices(1));
        c3.setText("c " + Main.toexam.getQuestions()[i].getChoices(2));
        c4.setText("d " + Main.toexam.getQuestions()[i].getChoices(3));
    }
    @FXML
    void ret(ActionEvent event)throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();

    }
}
