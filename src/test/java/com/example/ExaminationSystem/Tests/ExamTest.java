package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.Course;
import com.example.ExaminationSystem.Models.Exam;
import com.example.ExaminationSystem.Models.ExamReport;
import com.example.ExaminationSystem.Models.Instructor;
import com.example.ExaminationSystem.Models.ExamReport;
import com.example.ExaminationSystem.Models.Histogram;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExamTest {

    private Exam exam;

    @Before
    public void setUp() throws Exception {
        Instructor instructor = new Instructor("i1", "i", "khalil", "11", "45", 11);
        Course course = new Course("C001", "Introduction to Programming", "COMP101", instructor);
        String date = "12/12/2019";

        exam = new Exam(course, 30F, 9F, 11F, date);
    }

    @After
    public void tearDown() throws Exception {
        exam = null;
    }

    @Test
    public void getMark() {
        float expected =30F;
        assertEquals(expected, exam.getMark(), 30F);
    }

    @Test
    public void testSetDuration() {
        // Arrange
        float duration = 90.0f;

        // Act
        exam.setDuration(duration);

        // Assert
        assertEquals(duration, exam.getDuration(), 0.1);
    }

    @Test
    public void testSetStartTime() {
        // Arrange
        float startTime = 10.0f;

        // Act
        exam.setStartTime(startTime);

        // Assert
        assertEquals(startTime, exam.getStartTime(), 0.1);
    }

    @Test
    public void testSetMark() {
        // Arrange
        int mark = 80;

        // Act
        exam.setMark(mark);

        // Assert
        assertEquals(mark, exam.getMark());
    }

    @Test
    public void testGetCourse() {
        // Arrange
        String expectedCourse = "Introduction to Programming";

        // Act
        String actualCourse = exam.getCourse();

        // Assert
        assertEquals(expectedCourse, actualCourse);
    }

    @Test
    public void testGetCourseCode() {
        // Arrange
        String expectedCourseCode = "M101";

        // Act
        String actualCourseCode = exam.getCourse_Code();

        // Assert
        assertEquals(expectedCourseCode, actualCourseCode);
    }

    @Test
    public void testGetInsName() {
        // Arrange
        String expectedInsName = "John";

        // Act
        String actualInsName = exam.getInsName();

        // Assert
        assertEquals(expectedInsName, actualInsName);
    }
}