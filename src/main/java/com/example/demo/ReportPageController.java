package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ReportPageController {
    @FXML
    private Button returnb;
    @FXML
    private ChoiceBox<Integer> examcode; //exam code to choose which exam to display its report
    @FXML
    private Label err;
    @FXML
    private BarChart<Number, String> graph;
    @FXML
    private Label lab;
    @FXML
    private CategoryAxis mark;

    private NumberAxis noStu;
    @FXML
    private Label toughquestions;
    @FXML
    private Label tt;
    @FXML
    void reportdis(ActionEvent event) {
        if(examcode.getSelectionModel().isEmpty()==false)
        {
            err.setText("");
            tt.setVisible(true);
            toughquestions.setVisible(true);
            graph.setVisible(true);
            //set text here display tough questions through tl

            XYChart.Series series =new XYChart.Series();
            series.setName(""); //add exam code/course name
            //loop on number of grades and number of students
            int x = examcode.getSelectionModel().getSelectedIndex();
            int[] arr = Main.exams.get(x).getExam_report().getHisto().getFrequency_arr();
            ArrayList<String> s=new ArrayList<String>();
            Main.exams.get(x).getExam_report().getHisto().display();
            for(int i = 0; i < arr.length; i++)
                series.getData().add(new XYChart.Data(new String(String.valueOf(i)),arr[i] ));

            toughquestions.setText(Main.exams.get(x).getExam_report().display_tough());
            graph.getData().addAll(series);
        }
        else
            err.setText("Choose an exam!");
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
    public void initialize() {
        for(int i = 0; i< Main.exams.size(); i++)
            examcode.getItems().add(Main.exams.get(i).getID());
        //examcode.getItems().add("   "); //loop on exam codes of the instructor
        graph.setVisible(false);
        tt.setVisible(false);
        toughquestions.setVisible(false);
    }
    @FXML
    public void ver(){
        toughquestions.setText(Main.exams.get(examcode.getSelectionModel().getSelectedIndex()).getExam_report().showrank());
    }
}