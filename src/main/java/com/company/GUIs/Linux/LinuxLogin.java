package com.company.GUIs.Linux;

//Imports
import com.company.GUIcontainers.GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
This class manages the log-in panel (front-end)

    Public methods:
        getMainContainer
            Description:
                Returns the main panel container of this Window

            Returns:
                JPanel -> The main container
*/

public class LinuxLogin {
    private JPanel mainContainer;
    private JLabel LoginTitle;
    private JPanel inputContainer;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton goBackButton;
    private JButton loginButton;
    private JLabel usernameTitle;

    public LinuxLogin(GUI gui){
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.goToMainWindow();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insertedUsername = usernameInput.getText().trim();
                String insertedPassword = passwordInput.getText().trim();

                gui.loginAttempt(insertedUsername, insertedPassword);
            }
        });
    };

    public JPanel getMainContainer(){
        return mainContainer;
    }
}
