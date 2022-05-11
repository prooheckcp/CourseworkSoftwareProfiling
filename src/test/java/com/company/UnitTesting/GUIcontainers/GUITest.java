package com.company.UnitTesting.GUIcontainers;

//Imports
import com.company.AccountManagers.User;
import com.company.GUIcontainers.linuxGUI;
import com.company.GUIcontainers.windowsGUI;
import com.company.Utiliity.Data;
import com.company.Utiliity.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.swing.*;

/*
This testing file tests the methods provided by the GUI, linuxGUI and windowsGUI class
*/

public class GUITest {
    private static linuxGUI Linux;
    private static windowsGUI Windows;

    @BeforeAll
    static void setData(){
        Linux = new linuxGUI();
        Windows = new windowsGUI();

        Linux.start();
        Windows.start();
    }

    @DisplayName("Testing Getters")
    @Test
    void testGetters(){
        Assertions.assertNotNull(Windows.getMainPanel());
        Assertions.assertNotNull(Windows.getRegisterPanel());
        Assertions.assertNotNull(Windows.getLoginPanel());
        Assertions.assertNotNull(Windows.getProfilePanel());
        Assertions.assertNotNull(Windows.getAuthenticationPanel());
        Assertions.assertNotNull(Windows.getAccountDetailsPanel());
    }

    @DisplayName("Testing Setters")
    @Test
    void testSetters(){
        JPanel panel = new JPanel();

        Linux.setMainPanel(panel);
        Assertions.assertEquals(Linux.getMainPanel(), panel);
        Linux.setRegisterPanel(panel);
        Assertions.assertEquals(Linux.getRegisterPanel(), panel);
        Linux.setLoginPanel(panel);
        Assertions.assertEquals(Linux.getLoginPanel(), panel);
        Linux.setProfilePanel(panel);
        Assertions.assertEquals(Linux.getProfilePanel(), panel);
        Linux.setAuthenticationPanel(panel);
        Assertions.assertEquals(Linux.getAuthenticationPanel(), panel);
        Linux.setAccountDetailsPanel(panel);
        Assertions.assertEquals(Linux.getAccountDetailsPanel(), panel);
    }

    @DisplayName("Testing register attempt")
    @Test
    void testRegister(){
        Windows.registerAttempt("someUser", "somePass");
        Tuple<Boolean, User> response = Data.getUser("someUser");
        Assertions.assertEquals(response.getValue1(), true);
        Assertions.assertEquals(Windows.getCurrentPanel(), Windows.getProfilePanel());
    }

    @DisplayName("Testing login attempt")
    @Test
    void testLogin(){
        Windows.loginAttempt("prooheckcp", "password");
        Assertions.assertEquals(Windows.getCurrentPanel(), Windows.getProfilePanel());
    }
}
