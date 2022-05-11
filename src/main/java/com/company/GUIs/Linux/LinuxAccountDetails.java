package com.company.GUIs.Linux;

//Imports
import com.company.GUIcontainers.GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
This class manages the account details panel (front-end)

    Public methods:
        setupUsername
            Description:
                Updates the username text label of the GUI

            Arguments:
                username : String -> The new username label

        setupEmail
            Description:
                Updates the email text label of the GUI

            Arguments:
                email : String -> the new email label

        setupPhoneNumber
            Description:
                Updates the phone number text label of the GUI

            Arguments:
                phoneNumber : String -> The new phone number label

        setupAuthenticationMethod
            Description:
                Update the authentication method text label of the GUI

            Arguments:
                AuthenticationMethod : String -> The new authentication method label

        getMainContainer
            Description:
                Returns the main panel container of this Window

            Returns:
                JPanel -> The main container
*/

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
