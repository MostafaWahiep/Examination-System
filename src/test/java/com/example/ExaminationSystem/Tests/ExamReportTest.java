package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExamReportTest {
    private ExamReport examReport;
    @Before
    public void setUp() throws Exception {
        Instructor instructor = new Instructor("i2", "j", "Ahmed", "22", "55", 22);
        Course course = new Course("C002", "Data Structures and Algorithms", "COMP201", instructor);
        String date = "07/08/2023";

        Exam exam = new Exam(course, 120F, 14F, 16F, date);
        Histogram histo = new Histogram( exam);
        examReport = new ExamReport(exam, histo);

    }

    @After
    public void tearDown() throws Exception {
        examReport = null;
    }
    @Test
    public void display_tough() {
        String[] choices1 = {"Paris", "Madrid", "Rome", "Berlin"};
        Question q1 = new Question("What is the capital of France?", choices1, 'a', 3);
        q1.check_ans('B');
        q1.check_ans('C');

        String[] choices2 = {"Mount Everest", "K2", "Makalu", "Cho Oyu"};
        Question q2 = new Question("What is the tallest mountain in the world?", choices2, 'a', 5);
        q2.check_ans('B');

        Instructor instructorX = new Instructor("i2", "j", "Mahed", "22", "55", 55);
        Course course = new Course("C112", "Datanbase", "COMP201", instructorX);
        String date = "07/08/2023";

        Exam exam = new Exam(course, 120F, 14F, 16F, date);

        exam.addquestion(q1);
        exam.addquestion(q2);

        ExamReport examReport = new ExamReport(exam, new Histogram(exam));

        String toughQuestions = examReport.display_tough();

        assertEquals("1. What is the capital of France?\n" +
                "2. What is the tallest mountain in the world?\n", toughQuestions);
    }
    @Test
    public void showrank() {

        String[] choices3 = {"Russia", "Canada", "China", "USA"};
        Question q3 = new Question("What is the largest country in the world by area?", choices3, 'A', 4);
        q3.check_ans('B');
        q3.check_ans('C');
        q3.check_ans('D');

        String[] choices4 = {"Vatican City", "Monaco", "Nauru", "Tuvalu"};
        Question q4 = new Question("What is the smallest country in the world by area?", choices4, 'A', 5);
        q4.check_ans('A');

        String[] choices5 = {"Angel Falls", "Iguazu Falls", "Victoria Falls", "Niagara Falls"};
        Question q5 = new Question("What is the highest waterfall in the world?", choices5, 'A', 4);
        q5.check_ans('B');
        q5.check_ans('C');
        Instructor instructor = new Instructor("i3", "k", "John", "33", "66", 33);
        Course course = new Course("C003", "Database Management", "COMP202", instructor);
        String date = "09/10/2023";

        Exam exam = new Exam(course, 90F, 10F, 12F, date);
        Histogram histo = new Histogram( exam);
        exam.addquestion(q3);
        exam.addquestion(q4);
        exam.addquestion(q5);
        examReport = new ExamReport(exam, histo);

        String expectedRank = "1.0. What is the largest country in the world by area?. Rank: high\n" +
                "2.0. What is the highest waterfall in the world?. Rank: high\n" +
                "3.0. What is the smallest country in the world by area?. Rank: low\n";

        String actualRank = examReport.showrank();

        assertEquals(expectedRank, actualRank);



    }

    @Test
    public void sortquestions() {
        String[] choices1 = {"Paris", "Madrid", "Rome", "Berlin"};
        Question q1 = new Question("What is the capital of France?", choices1, 'a', 3);
        q1.check_ans('B');
        q1.check_ans('C');

        String[] choices2 = {"Mount Everest", "K2", "Makalu", "Cho Oyu"};
        Question q2 = new Question("What is the tallest mountain in the world?", choices2, 'a', 5);
        q2.check_ans('B');

        Instructor instructorX = new Instructor("i2", "j", "Mahed", "22", "55", 55);
        Course course = new Course("C112", "Datanbase", "COMP201", instructorX);
        String date = "07/08/2023";

        Exam exam = new Exam(course, 120F, 14F, 16F, date);

        exam.addquestion(q1);
        exam.addquestion(q2);

        ExamReport examReport = new ExamReport(exam, new Histogram(exam));
        examReport.sortquestions();
        assertEquals("1. What is the tallest mountain in the world?\n" +
                "2. What is the capital of France?\n", examReport.display_tough());
    }

    @Test
    public void getHisto() {
        String[] choices1 = {"Paris", "Madrid", "Rome", "Berlin"};
        Question q1 = new Question("What is the capital of France?", choices1, 'a', 3);
        q1.check_ans('B');
        q1.check_ans('C');

        String[] choices2 = {"Mount Everest", "K2", "Makalu", "Cho Oyu"};
        Question q2 = new Question("What is the tallest mountain in the world?", choices2, 'a', 5);
        q2.check_ans('B');

        Instructor instructorX = new Instructor("i2", "j", "Mahed", "22", "55", 55);
        Course course = new Course("C112", "Datanbase", "COMP201", instructorX);
        String date = "07/08/2023";

        Exam exam = new Exam(course, 120F, 14F, 16F, date);

        exam.addquestion(q1);
        exam.addquestion(q2);
        Histogram histo = new Histogram(exam);
        ExamReport examReport = new ExamReport(exam, histo);

        int[] grades = {70, 80, 90};
        for (int grade : grades) {
            histo.addgrade(grade);
        }
        assertEquals(histo, examReport.getHisto());
    }

}