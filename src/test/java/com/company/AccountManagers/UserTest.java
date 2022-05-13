package com.company.AccountManagers;

//Imports
import com.company.AccountManagers.User;
import com.company.enums.AuthenticationMethod;
import com.company.enums.Privilege;
import org.junit.jupiter.api.*;

/*
This testing file tests the methods provided by the user class
*/

public class UserTest {
    //Constants
    static final private Privilege PSEUDO_PRIVILEGE = Privilege.GUEST;
    static final private String PSEUDO_USERNAME = "SomeUsername";
    static final private String PSEUDO_PASSWORD = "SomePassword";
    static final private String PSEUDO_EMAIL = "vasco.soares.2001@gmail.com";
    static final private String PSEUDO_PHONE_NUMBER = "+351 918 495 220";
    static final private AuthenticationMethod PSEUDO_AUTHENTICATION_METHOD = AuthenticationMethod.EMAIL;

    //Variables
    static private User testUser;
    static private User testUser2;

    @BeforeAll
    static void setData(){
        testUser = new User(
                PSEUDO_USERNAME,
                PSEUDO_PASSWORD,
                PSEUDO_PRIVILEGE
        );

        testUser2 = new User(
                PSEUDO_USERNAME+"2",
                PSEUDO_PASSWORD,
                PSEUDO_PRIVILEGE,
                PSEUDO_AUTHENTICATION_METHOD
        );
    }

    @DisplayName("Assure setters and getters are working correctly")
    @Test
    void assertSetters(){
        //Check testUser2 constructors
        Assertions.assertEquals(testUser2.getUsername(), PSEUDO_USERNAME+"2");
        Assertions.assertEquals(testUser2.getPassword(), PSEUDO_PASSWORD);
        Assertions.assertEquals(testUser2.getPrivilege(), PSEUDO_PRIVILEGE);
        Assertions.assertEquals(testUser2.getAuthenticationMethod(), PSEUDO_AUTHENTICATION_METHOD);
        
        //Check if the constructors worked
        Assertions.assertEquals(testUser.getUsername(), PSEUDO_USERNAME);
        Assertions.assertEquals(testUser.getPrivilege(), PSEUDO_PRIVILEGE);
        Assertions.assertEquals(testUser.getAuthenticationMethod(), AuthenticationMethod.NONE);

        //Set the pseudo data
        Boolean successEmail = testUser.setEmail(PSEUDO_EMAIL);
        Boolean successPhoneNumber = testUser.setPhoneNumber(PSEUDO_PHONE_NUMBER);
        Boolean successAuthentication = testUser.setAuthenticationMethod(PSEUDO_AUTHENTICATION_METHOD);

        //Assert changes succeeded
        Assertions.assertEquals(successEmail, true);
        Assertions.assertEquals(successPhoneNumber, true);
        Assertions.assertEquals(successAuthentication, true);

        //Get the pseudo data
        Privilege userPrivilege = testUser.getPrivilege();
        AuthenticationMethod userAuthenticationMethod = testUser.getAuthenticationMethod();
        String userName = testUser.getUsername();
        String userPassword = testUser.getPassword();
        String userPhoneNumber = testUser.getPhoneNumber();
        String userEmail = testUser.getEmail();

        //Assert the data values
        Assertions.assertEquals(userPrivilege, PSEUDO_PRIVILEGE);
        Assertions.assertEquals(userAuthenticationMethod, PSEUDO_AUTHENTICATION_METHOD);
        Assertions.assertEquals(userName, PSEUDO_USERNAME);
        Assertions.assertEquals(userPassword, PSEUDO_PASSWORD);
        Assertions.assertEquals(userPhoneNumber,PSEUDO_PHONE_NUMBER);
        Assertions.assertEquals(userEmail, PSEUDO_EMAIL);
    }
}
