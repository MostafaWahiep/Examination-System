package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student;
    @Before
    public void setUp() throws Exception {
        student = new Student("s1", "a", "Ahmed", "11", "44", "ayman@gmail.com");

    }

    @After
    public void tearDown() throws Exception {
        student = null;
    }

    @Test
    public void verify_login() {
        Student student = new Student("s2", "b", "Mohamed", "22", "55", "max@gmail.com");
        User user1 = new User("s2", "b");
        User user2 = new User("s2", "password"); // Incorrect password
        user1.verify_login(student);
        user2.verify_login(student);
        boolean expected1 = true;
        boolean expected2 = true;
        assertEquals(expected1, user1.verify_login(student));
        assertEquals(expected2, user2.verify_login(student));
    }

    @Test
    public void getName() {
        String expected = "Ahmed";
        String actual = student.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void addexam() {
        Instructor instructor = new Instructor("i1", "i", "khalil", "11", "45", 11);
        Course course = new Course("C001", "Introduction to Programming", "COMP101", instructor);
        String date = "12/12/2019";
        Exam exam = new Exam(course, 30F, 9F, 11F, date);
        student.addexam(exam);
        assertEquals(exam, student.getExams().get(0));
    }
}