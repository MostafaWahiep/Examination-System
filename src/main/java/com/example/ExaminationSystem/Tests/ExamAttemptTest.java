package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Main;
import com.example.ExaminationSystem.Models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExamAttemptTest {

    private ExamAttempt examAttempt;
    private Student student;

    @Before
    public void setUp() throws Exception{
        Main.initialize();
        student = new Student("Mahmoud", "123456", "Mahmoud", "123456", "123456", "123456");
        examAttempt = new ExamAttempt(student, Main.exams.get(0), "12/12/2019", 11, 7, 7);
    }

    @After
    public void tearDown() throws Exception {
        examAttempt = null;
        student = null;
    }

    @Test
    public void getStudent() {
        String expected = student.getName();
        assertEquals(expected, examAttempt.getStudent());
    }

    @Test
    public void getExam() {
        Integer expected = Main.exams.get(0).getID();
        assertEquals(expected, examAttempt.getExam());
    }

    @Test
    public void getGrade() {
        float expected = 10;
        assertEquals(expected, examAttempt.getGrade(), 10);
    }

    @Test
    public void getDate() {
        String expected = "12/12/2019";
        assertEquals(expected, examAttempt.getDate());
    }

    @Test
    public void getAnswered_questions() {
        Integer expected = 7;
        assertEquals(expected, examAttempt.getAnswered_questions());
    }

    @Test
    public void getCorrect_answers() {
        Integer expected = 7;
        assertEquals(expected, examAttempt.getCorrect_answers());
    }

    @Test
    public void getCourse() {
        String expected = Main.exams.get(0).getCourse_Code();
        assertEquals(expected, examAttempt.getCourse());
    }

    @Test
    public void getFeedback() {
        String expected = "You did well";
        examAttempt.setFeedback(expected);
        assertEquals(expected, examAttempt.getFeedback());
    }

    @Test
    public void getGradePercentage() {
        float expected = 100F;
        assertEquals(expected, examAttempt.getGradePercentage(), 0);
    }

    @Test
    public void getNum_questions() {
        Integer expected = 7;
        assertEquals(expected, examAttempt.getNum_questions());
    }
}