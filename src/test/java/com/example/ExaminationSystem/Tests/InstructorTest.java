package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.Instructor;
import com.example.ExaminationSystem.Models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructorTest {

    private Instructor instructor;
    @Before
    public void setUp() throws Exception {
        instructor = new Instructor("i2", "j", "Mohamed", "22", "55", 22);
    }

    @After
    public void tearDown() throws Exception {
        instructor = null;
    }

    @Test
    public void verify_login() {
        Instructor instructor = new Instructor("i3", "k", "John", "33", "66", 33);
        User user1 = new User("i3", "k");
        User user2 = new User("i3", "password"); // Incorrect password

        boolean expected1 = true;
        boolean expected2 = false;

        boolean actual1 = instructor.verify_login(user1);
        boolean actual2 = instructor.verify_login(user2);

        assertTrue(actual1);
        assertFalse(actual2);
    }

    @Test
    public void getName() {
        String expected = "Ahmed";
        String actual = instructor.getName();
        assertEquals(expected, actual);
    }
}