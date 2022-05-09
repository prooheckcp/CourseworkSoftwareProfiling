package com.company;

import com.company.AccountManagers.User;
import com.company.Authentication.EmailAuthentication;
import com.company.Authentication.PasswordAuthentication;
import com.company.Authentication.TwoFactorAuthentication;
import com.company.Utiliity.Util;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

public class AuthenticationTest {

    static User user;
    static EmailAuthentication emailAuthentication;
    static PasswordAuthentication passwordAuthentication;
    static TwoFactorAuthentication twoFactorAuthentication;

    @BeforeAll
    static void setData(){
        user = new User("TestUser", "Password");
        emailAuthentication = new EmailAuthentication();
        passwordAuthentication = new PasswordAuthentication();
        twoFactorAuthentication = new TwoFactorAuthentication();
    }

    @DisplayName("Attempt to log in with phone sms")
    @ParameterizedTest
    @ValueSource(strings = {"925", "816", "512", "123"})
    void attempt2FA(String code){
        ByteArrayInputStream in = new ByteArrayInputStream(code.getBytes());
        System.setIn(in);
        boolean success = twoFactorAuthentication.loginAttempt(null, null);

        if(success)
            Util.print("Got code correct");
    }

    @DisplayName("Attempt to log in with email")
    @ParameterizedTest
    @ValueSource(strings = {"WSA ", "ABC ", "UWU", "OWO"})
    void attemptEmail(String code){
        ByteArrayInputStream in = new ByteArrayInputStream(code.getBytes());
        System.setIn(in);
        boolean success = emailAuthentication.loginAttempt(null, null);

        if(success)
            Util.print("Got code correct");
    }

    @DisplayName("Attempting to log in with multiple passwords")
    @ParameterizedTest
    @ValueSource(strings = {"Joining ", "Password ", "words ", "together"})
    void attemptPassword(String password){
        boolean success = passwordAuthentication.loginAttempt(user, password);
        if(success)
            Util.print("Logged in with the password: " + password);
        else
            Util.print("Failed to log in with the password:" + password);
    }
}
