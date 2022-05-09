package com.company;

import com.company.AccountManagers.User;
import com.company.enums.AuthenticationMethod;
import com.company.enums.Privilege;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayInputStream;

/*
This file tests the menu actions used on the app
*/

public class MenuActionsTest{

    //All the actions that exist
    static User user;
    static User user2;

    @BeforeAll
    static void startData(){
        user = new User(
                "RandomUser",
                "randomPass",
                        Privilege.ADMIN,
                        AuthenticationMethod.NONE
                    );

        user2 = new User(
                    "AnotherUser",
                    "anotherPass",
                            Privilege.GUEST,
                            AuthenticationMethod.TWO_FACTOR
                    );
    }

    @DisplayName("Testing log in attempt")
    @Test
    void loginAttempt(){
        //Force log-out in case the log in works
        ByteArrayInputStream argumentsIn = new ByteArrayInputStream("3".getBytes());
        System.setIn(argumentsIn);
    }

    @DisplayName("Testing log in attempt with 2FA")
    @Test
    void loginAttempt2FA(){
        //Attempts to use the code "123" to log in and then log out
        String simulatedInput = "123"
                + System.getProperty("line.separator")
                + "3";
        //Force log-out in case the log in works
        ByteArrayInputStream argumentsIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(argumentsIn);
    }

    @DisplayName("Testing log in functionality")
    @ParameterizedTest
    @CsvSource({ "proohekcp,wrongPass", "randomUser,password", "prooheckcp,password" })
    void loginUser(String username, String password){
        String simulatedInput = username
                                + System.getProperty("line.separator")
                                + password;

        ByteArrayInputStream argumentsIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(argumentsIn);
    }

    @DisplayName("Testing register functionality")
    @Test
    void registerUser(){
        String username = "randomUser";
        String password = "password";
        String simulatedInput =
                username
                + System.getProperty("line.separator")
                + password
                + System.getProperty("line.separator")
                + "3"
                + System.getProperty("line.separator");

        ByteArrayInputStream argumentsIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(argumentsIn);
    }

    @DisplayName("Testing register functionality")
    @Test
    void registerUser2(){
        String username = "proohekcp";
        String password = "wrongPass";
        String simulatedInput =
                username
                        + System.getProperty("line.separator")
                        + password
                        + System.getProperty("line.separator")
                        + "3"
                        + System.getProperty("line.separator");

        ByteArrayInputStream argumentsIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(argumentsIn);
    }

    @DisplayName("Testing register functionality")
    @Test
    void registerUser3(){
        String username = "prooheckcp";
        String password = "password";
        String simulatedInput =
                username
                        + System.getProperty("line.separator")
                        + password
                        + System.getProperty("line.separator")
                        + "3"
                        + System.getProperty("line.separator");

        ByteArrayInputStream argumentsIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(argumentsIn);
    }
}
