package com.company.GUIs.Linux;

import com.company.GUIcontainers.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinuxRegister {
    private JPanel mainContainer;
    private JLabel RegisterTitle;
    private JTextField passwordInput;
    private JTextField usernameInput;
    private JButton registerButton;
    private JButton goBackButton;
    private JPanel inputContainer;
    private JLabel usernameTitle;

    public LinuxRegister(GUI gui){
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
