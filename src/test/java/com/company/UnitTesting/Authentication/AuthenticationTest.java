package com.company.UnitTesting.Authentication;

//Imports
import com.company.AccountManagers.User;
import com.company.Authentication.EmailAuthentication;
import com.company.Authentication.PasswordAuthentication;
import com.company.Authentication.TwoFactorAuthentication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @Test
    void attempt2FA(){
        boolean success = twoFactorAuthentication.loginAttempt(null, null);

        Assertions.assertEquals(success, false);
    }

    @DisplayName("Attempt to log in with email")
    @Test
    void attemptEmail(){
        boolean success = emailAuthentication.loginAttempt(null, null);

        Assertions.assertEquals(success, false);
    }

    @DisplayName("Attempting to log in with multiple passwords")
    @ParameterizedTest
    @ValueSource(strings = {"Joining", "Password", "words", "together"})
    void attemptPassword(String password){
        Boolean passwordsAreEqual = password.equals(user.getPassword());
        boolean success = passwordAuthentication.loginAttempt(user, password);

        if(passwordsAreEqual)
            Assertions.assertEquals(success, true);
        else
            Assertions.assertEquals(success, false);
    }
}
