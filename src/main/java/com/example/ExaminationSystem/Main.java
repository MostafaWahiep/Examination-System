package com.example.ExaminationSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    /*
    0-->none(default)
    1-->adminstrator
    2-->instructor
    3-->student
    */
    static int UserType = 0;
    static ArrayList<Student> students;
    static ArrayList<Instructor> instructors;
    static ArrayList<Adminstrator> admins;
    static ArrayList<Exam> exams;
    static ArrayList<Course> courses;
    static Exam toexam = null;
    public static int nom=0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 612);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Student s1 = new Student("s1", "p", "khalil", "1", "11", "45");
        Student s2 = new Student("s2", "p", "Donia", "2", "11", "45");
        Student s3 = new Student("s3", "p", "Omar", "3", "11", "45");
        Student s4 = new Student("s4", "p", "Nour", "4", "11", "45");
        Student s5 = new Student("s5", "p", "Abdelrahman", "5", "11", "45");
        Instructor i1 = new Instructor("i1", "i", "khalil", "11", "45", 11);
        Instructor i2 = new Instructor("i2", "i", "Hossam", "11", "45", 11);
        Adminstrator a1 = new Adminstrator("a1", "a");
        Adminstrator a2 = new Adminstrator("a1", "a");
        students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        instructors = new ArrayList<Instructor>();
        instructors.add(i1);
        instructors.add(i2);
        admins = new ArrayList<Adminstrator>();
        Course opp = new Course("oop1", "oop", "cse231", i1);
        Course logic = new Course("opp2", "logic", "cse111", i2);
        courses = new ArrayList<Course>();
        courses.add(opp);
        courses.add(logic);
        opp.setCourse_content("This is the content of the course of opp");
        logic.setCourse_content("This is the content of the course of logic");
        Exam exam = new Exam(opp, 30F, 9F, 11F,"64");
        Histogram his = new Histogram(exam);
        ExamReport exrp = new ExamReport(exam,his);
        exam.setExam_report(exrp);
        exams=new ArrayList<Exam>();
        exams.add(exam);
        String[] c1 = new String[]{"Computers", "Information appliances", "Digital cameras", "All of the mentioned"};
        String[] c2 = new String[]{"Full – adder", "Ripple – carry adder" , "Half – adder", "Serial adder"};
        String[] c3 = new String[]{"S" , "R" , "Clock" , "Both S and R"};
        String[] c4 = new String[]{"0", "1", "Clock", "Previous output"};
        String[] c5 = new String[]{"0","1","No change","Toggle between 0 and 1"};
        String[] c6 = new String[]{"No change","Toggle between 0 and 1","0","1"};
        String[] c7 = new String[]{"Multi-gate function","Multi-output function","Multiple-gate function","Multiple-output function"};
        Question q1 = new Question("Which of the following is an example of a digital Electronic?", c1,'d',2);
        Question q2 = new Question("Which of the following digital logic circuits can be used to add more than 1 – bit simultaneously?", c2,'b',3);
        Question q3 = new Question("Which of the following options represent the synchronous control inputs in an S – R flip flop?",c3,'d',1);
        Question q4 = new Question("What must be used along with synchronous control inputs to trigger a change in the flip flop?", c4,'c',1);
        Question q5 = new Question("What will be the output from a D flip – flop if the clock is low and D = 0?", c5,'c',1);
        Question q6 = new Question("What will be the output from a D flip-flop if D = 1 and the clock is low?", c6, 'a', 1);
        Question q7 = new Question("What is a switching function that has more than one output called in Digital Electronics?",c7,'b',2);
        exam.addquestion(q1);
        exam.addquestion(q2);
        exam.addquestion(q3);
        exam.addquestion(q4);
        exam.addquestion(q5);
        exam.addquestion(q6);
        exam.addquestion(q7);
        launch();
    }
    public static boolean stlogin(TestLogin T)
    {
        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).verify_login(T)==true)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean inlogin(TestLogin T)
    {
        for(int i=0;i<instructors.size();i++)
        {
            if(instructors.get(i).verify_login(T)==true)
            {
                return true;
            }
        }
        return false;
    }
}