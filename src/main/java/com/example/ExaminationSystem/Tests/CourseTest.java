package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    private Course course;
    private Exam exam;
    private Instructor instructor;

    @Before
    public void setUp(){
        instructor = new Instructor("i1", "i", "khalil", "11", "45", 11);
        course = new Course("C001", "Introduction to Programming", "COMP101", instructor);
        exam = new Exam(course, 30F, 9F, 11F,"64");
    }

    @After
    public void tearDown(){
        course = null;
        exam = null;
        instructor = null;
    }

    @Test
    public void getCourse_content() {
        String course_content = "This is a test course content for testing purposes only and should/n not be used in production environment.";
        course.setCourse_content(course_content);
        assertEquals(course_content, course.getCourse_content());
    }

    @Test
    public void getName() {
        String expected = "Introduction o Programming";
        assertEquals(expected, course.getName());
    }

    @Test
    public void getCourse_code() {
        String expected = "COMP101";
        assertEquals(expected, course.getCourse_code());
    }

    @Test
    public void getInstructor() {
        assertEquals(instructor, course.getInstructor());
    }

    @Test
    public void addExam() {
        course.addExam(exam);
        assertEquals(exam, course.getSetofexams()[0]);
    }

    @Test
    public void getID() {
        String expected = "C001";
        assertEquals(expected, course.getID());
    }
}