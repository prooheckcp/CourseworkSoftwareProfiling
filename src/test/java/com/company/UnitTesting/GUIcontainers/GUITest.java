package com.company.UnitTesting.GUIcontainers;

import com.company.GUIcontainers.linuxGUI;
import com.company.GUIcontainers.windowsGUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

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
}
