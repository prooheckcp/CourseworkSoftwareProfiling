package com.company.GUIs.Windows;

import com.company.GUIcontainers.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsLogin {
    private JPanel mainContainer;
    private JLabel LoginTitle;
    private JPanel inputContainer;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton goBackButton;
    private JButton loginButton;
    private JLabel usernameTitle;

    public WindowsLogin(GUI gui){
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
