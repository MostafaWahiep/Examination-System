package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.Adminstrator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminstratorTest {

    public Adminstrator adminstrator;
    private Adminstrator administrator;

    @Before
    public void setUp() throws Exception {
        // Create a new Administrator object for each test
         administrator = new Adminstrator("admin", "password");
    }

    @After
    public void tearDown() throws Exception {
        // Clean up any resources used by the test
        administrator = null;
    }
    @Test
    public void verify_login_should_return_true_for_correct_credentials() {
        // Arrange
        String username = "admin";
        String password = "password";

        // Assert
        assertEquals(true, administrator.verify_login(new Adminstrator(username, password)));
    }
    @Test
    public void verify_login_should_return_true_for_incorrect_credentials() {
        // Arrange
        String username = "admin";
        String password = "wrongpassword";

        // Assert
        assertFalse(administrator.verify_login(new Adminstrator(username, password)));
    }

}
