package com.company.GUIs.Windows;

//Imports
import com.company.GUIcontainers.GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
This class manages the register anel (front-end)

    Public methods:
        getMainContainer
            Description:
                Returns the main panel container of this Window

            Returns:
                JPanel -> The main container
*/
public class WindowsRegister {
    private JPanel mainContainer;
    private JLabel RegisterTitle;
    private JTextField passwordInput;
    private JTextField usernameInput;
    private JButton registerButton;
    private JButton goBackButton;
    private JPanel inputContainer;
    private JLabel usernameTitle;

    public WindowsRegister(GUI gui){
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.goToMainWindow();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insertedUsername = usernameInput.getText().trim();
                String insertedPassword = passwordInput.getText().trim();

                gui.registerAttempt(insertedUsername, insertedPassword);
            }
        });
    };

    public JPanel getMainContainer(){
        return mainContainer;
    }
}
