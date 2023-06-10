package com.example.ExaminationSystem.Tests;

import com.example.ExaminationSystem.Models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    @Before
    public void setUp() throws Exception {
        User user = new User("Ahmed", "123456");

    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void verify_login() {
        user = new User("Ahmed", "123456");

        boolean expected = true;
        boolean actual = user.verify_login(user);
        assertEquals(expected, actual);
    }
}