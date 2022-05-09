package com.company;

import com.company.AccountManagers.Profile;
import com.company.AccountManagers.User;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;

/*
This testing file tests the methods provided by the profile class
*/


public class ProfileTest {
    static User user;

    @BeforeAll
    static void setData(){
        user = new User("RandomUser", "password");
    }

    @DisplayName("Testing logging in")
    @Test
    void loggingIntoAccounts(){
        ByteArrayInputStream argumentsIn = new ByteArrayInputStream("3".getBytes());
        System.setIn(argumentsIn);
        Profile.login(user);
        Profile.login(null);
    }
}
