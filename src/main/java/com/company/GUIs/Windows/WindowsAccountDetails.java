package com.company.GUIs.Windows;

import com.company.GUIcontainers.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsAccountDetails {
    private JPanel mainContainer;
    private JLabel mainTitle;
    private JButton goBackButton;
    private JLabel description;

    public WindowsAccountDetails(GUI gui){
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
