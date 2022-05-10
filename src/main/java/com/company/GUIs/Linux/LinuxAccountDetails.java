package com.company.GUIs.Linux;

import com.company.GUIcontainers.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinuxAccountDetails {
    private JPanel mainContainer;
    private JLabel mainTitle;
    private JButton goBackButton;
    private JLabel usernameTitle;
    private JLabel username;
    private JLabel email;
    private JLabel phoneNumber;
    private JLabel privilege;
    private JLabel authenticationMethod;
    private JLabel emailTitle;
    private JLabel phoneNumberTitle;
    private JLabel privilegeTitle;
    private JLabel authenticationMethodTitle;

    public void setupUsername(String _username){
        username.setText(_username);
    }

    public void setupEmail(String _email){
        email.setText(_email);
    }

    public void setupPhoneNumber(String _phoneNumber){
        phoneNumber.setText(_phoneNumber);
    }

    public void setupPrivilege(String _privilege){
        privilege.setText(_privilege);
    }

    public void setupAuthenticationMethod(String _authenticationMethod){
        authenticationMethod.setText(_authenticationMethod);
    }

    public LinuxAccountDetails(GUI gui){
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.goToProfileWindow();
            }
        });
    }

    public JPanel getMainContainer(){
        return mainContainer;
    }
}
