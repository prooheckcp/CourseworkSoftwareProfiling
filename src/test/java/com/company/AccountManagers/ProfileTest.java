package com.company.AccountManagers;

//Imports
import com.company.Utility.Data;
import com.company.Utility.Tuple;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
This testing file tests the methods provided by the Profile class
*/

public class ProfileTest {

    static private final int MINIMUM_USERNAME_LENGTH = 3;
    static private final int MAXIMUM_USERNAME_LENGTH = 12;
    static private final int MINIMUM_PASSWORD_LENGTH = 3;
    static private final int MAXIMUM_PASSWORD_LENGTH = 12;
    static private User testingUser;

    @BeforeAll
    static void testData(){
        testingUser = new User(
                "someUser",
                "somePassword"
        );
    }

    @DisplayName("Testing login attempt")
    @ParameterizedTest
    @CsvSource({ "proohekcp,wrongPass", "12,password", "prooheckcp,32", "prooheckcp,password" })
    void loginAttemptTest(String username, String password){
        int usernameLength = username.length();
        int passwordLength = password.length();
        Tuple<Boolean, User> userExists = Data.getUser(username); //Check if the user exists
        Tuple<Boolean, String> response = Profile.loginAttempt(username, password);
        Boolean success = response.getValue1();

        if(
            usernameLength < MINIMUM_USERNAME_LENGTH ||
            usernameLength > MAXIMUM_USERNAME_LENGTH ||
            passwordLength < MINIMUM_PASSWORD_LENGTH ||
            passwordLength > MAXIMUM_PASSWORD_LENGTH ||
            !userExists.getValue1()
        )
            Assertions.assertEquals(success, false);
        else
            Assertions.assertEquals(success, true);
    }

    @DisplayName("Testing register attempt")
    @ParameterizedTest
    @CsvSource({ "proohekcp,wrongPass", "randomUser,password", "prooheckcp,password" })
    void registerAttemptTest(String username, String password){
        Tuple<Boolean, User> userExists = Data.getUser(username); //Check if the user exists
        Tuple<Boolean, String> response = Profile.registerAttempt(username, password);
        Boolean success = response.getValue1();

        if(userExists.getValue1())
            Assertions.assertEquals(success, false);
        else
            Assertions.assertEquals(success, true);
    }

    @DisplayName("Testing login")
    @Test
    void regularLogin(){
        Profile.login(testingUser);
        Assertions.assertEquals(testingUser, Profile.getCurrentUser());
    }

    @DisplayName("Testing logout")
    @Test
    void regularLogout(){
        Profile.login(testingUser); //Fill the log-in section
        Profile.logout();
        Assertions.assertNull(Profile.getCurrentUser()); //Current user should be null after logout
    }
}
