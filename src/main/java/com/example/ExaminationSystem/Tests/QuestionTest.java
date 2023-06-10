package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {
    private Question question;
    @Before
    public void setUp() throws Exception {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
    }

    @After
    public void tearDown() throws Exception {
        question = null;
    }

    @Test
    public void getEvaloution_rank() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        int expected = 9;
        int actual = question.getGrade();
        assertEquals(expected, actual);
    }

    @Test
    public void setEvaloution_rank() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        question.setEvaloution_rank("Excellent");
        String expected = "Excellent";
        String actual = question.getEvaloution_rank();
        assertEquals(expected, actual);
    }

    @Test
    public void setChoices() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        question.setChoices("Ahmed", 1);
        String expected = "Ahmed";
        String actual = question.getChoices(0);
        assertEquals(expected, actual);
    }

    @Test
    public void setGrade() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        question.setGrade(20);
        int expected = 20;
        int actual = question.getGrade();
        assertEquals(expected, actual);
    }

    @Test
    public void setCorrect_choice() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        question.setCorrect_choice('B');
        char expected = 'c';
        char actual = question.getCorrect_choice();
        assertEquals(expected, actual);
    }

    @Test
    public void getGrade() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        int expected = 10;
        int actual = question.getGrade();
        assertEquals(expected, actual);

    }

    @Test
    public void getName() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        String expected = "What is your name?";
        String actual = question.getName();
        assertEquals(expected, actual);
    }


    @Test
    public void getChoices() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'A', 10);
        String expected = "Ahmed";
        String actual = question.getChoices(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getCorrect_choice() {
        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'B', 10);
        char expected = 'B';
        char actual = question.getCorrect_choice();
        assertEquals(expected, actual);
    }

    @Test
    public void check_ans() {

        question = new Question("What is your name?", new String[]{"Ahmed", "Mohamed", "Ali", "Khaled"}, 'B', 10);
        int expected = 10;
        int actual = question.check_ans('B');
        assertEquals(expected, actual);
    }
}