package com.company;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;

/*
This testing file tests all the 3 actions possible to do from the user profile.
*/

public class ProfileOptions {

    @BeforeAll
    static void startData(){
        Data.authenticationList.put(AuthenticationMethod.PASSWORD, new PasswordAuthentication());
        Data.authenticationList.put(AuthenticationMethod.TWO_FACTOR, new TwoFactorAuthentication());
        Data.authenticationList.put(AuthenticationMethod.EMAIL, new EmailAuthentication());
    }

    @DisplayName("Attempt to get into changingAuthenticationMethod window")
    @Test
    void changingAuthenticationMethod() {
        ChangeAuthenticationMethod changeAuthenticationMethod = new ChangeAuthenticationMethod("Name");
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        changeAuthenticationMethod.Main();
    }

    @DisplayName("Attempt to check user details")
    @Test
    void checkAccountDetails(){
        CheckAccountDetails checkAccountDetails = new CheckAccountDetails("Name");
        checkAccountDetails.Main();
    }

    @DisplayName("Attempt to log out")
    @Test
    void logout(){
        Logout logout = new Logout("Name");
        Profile.currentUser = new User(
                            "RandomName",
                            "RandomPass");
        logout.Main();
        Assertions.assertNull(Profile.currentUser);
    }
}
