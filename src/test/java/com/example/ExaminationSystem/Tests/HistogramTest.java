package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HistogramTest {
    private Histogram histogram;

    @Before
    public void setUp() throws Exception {
        Instructor instructor = new Instructor("i2", "j", "Ahmed", "22", "55", 22);
        Course course = new Course("C002", "Data Structures and Algorithms", "COMP201", instructor);
        String date = "07/08/2023";

        Exam exam = new Exam(course, 120F, 14F, 16F, date);
        Histogram histogram = new Histogram( exam);
    }

    @After
    public void tearDown() throws Exception {
        histogram = null;
    }

    @Test
    public void getFrequency_arr() {
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
        exam.addquestion(q3);
        exam.addquestion(q4);
        exam.addquestion(q5);
        Histogram histo = new Histogram( exam);
        int[] freq = histo.getFrequency_arr();
        assertEquals(1, freq[0]);

    }

    @Test
    public void getGrades() {
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
        exam.addquestion(q3);
        exam.addquestion(q5);
        Histogram histo = new Histogram( exam);

        histo.addgrade(80);
        histo.addgrade(90);
        histo.addgrade(70);

        int[] expectedGrades = {80, 100, 70};
        assertArrayEquals(expectedGrades, histo.getGrades());


    }

    @Test
    public void addgrade() {
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
        exam.addquestion(q3);
        exam.addquestion(q5);
        Histogram histo = new Histogram( exam);

        histo.addgrade(80);
        histo.addgrade(90);
        histo.addgrade(70);
        int expectedSize = 3;
        assertEquals(expectedSize, histo.getGrades().length);


    }

    @Test
    public void processFrequency_arr() {
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
        exam.addquestion(q3);
        exam.addquestion(q5);
        Histogram histo = new Histogram( exam);

        histo.addgrade(3);
        histo.addgrade(1);
        histo.addgrade(2);
        histo.processFrequency_arr();
        int[] expectedFreq = {1, 0, 1};
        assertArrayEquals(expectedFreq, histo.getFrequency_arr());
    }
}