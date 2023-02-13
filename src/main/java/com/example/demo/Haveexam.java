package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Haveexam implements Initializable {
    Integer[] cc;
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
        x = HelloApplication.toexam.getNum_of_questions();
        ans = new char[x];
        cc = new Integer[x];
        for(int i = 0; i < x; i++)
            cc[i] = i +1 ;
        list.getItems().addAll(cc);
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
        for(int i = 0; i < x; i++)
        {
            grade += HelloApplication.toexam.getQuestions()[i].check_ans(ans[i]);
        }
        gradeee.setText("your grade is " + grade);
        HelloApplication.toexam.getExam_report().getHisto().addgrade(grade);

        c1.setDisable(true);
        c2.setDisable(true);
        c3.setDisable(true);
        c4.setDisable(true);
        finish.setDisable(true);
    }
    private void setquestion(Integer i){
        qname.setText(HelloApplication.toexam.getQuestions()[i].getName());
        c1.setText("a " + HelloApplication.toexam.getQuestions()[i].getChoices(0));
        c2.setText("b " + HelloApplication.toexam.getQuestions()[i].getChoices(1));
        c3.setText("c " + HelloApplication.toexam.getQuestions()[i].getChoices(2));
        c4.setText("d " + HelloApplication.toexam.getQuestions()[i].getChoices(3));
    }

    @FXML
    void ret(ActionEvent event)throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("Student.fxml"));
        Stage appst=(Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root1);
        appst.setScene(scene1);
        appst.show();

    }


}
