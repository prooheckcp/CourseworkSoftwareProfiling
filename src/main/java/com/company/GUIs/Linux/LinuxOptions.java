package com.company.GUIs.Linux;

/*
This is a template for Windows options panels
*/

import com.company.Utiliity.MenuAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class LinuxOptions {
    private JPanel mainContainer;
    private JLabel mainTitle;
    private JPanel buttonContainer;
    private JLabel description;

    private void generateButton(MenuAction menuAction){
        JButton newButton = new JButton(menuAction.actionName);
        newButton.setSize(new Dimension(400 ,20));
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAction.Main();
            }
        });
        buttonContainer.add(newButton);
    }

    public JPanel getMainContainer(){
        return this.mainContainer;
    }

    public void setDescription(String newDescription){
        description.setText(newDescription);
    }

    String test;
    public LinuxOptions(String menuName, String descriptionMessage, Vector<MenuAction> menuActions){
        mainTitle.setText(menuName);
        description.setText(descriptionMessage);
        test = menuName;
        for(int i = 0; i < menuActions.size(); i++){
            MenuAction menuAction = menuActions.get(i);
            generateButton(menuAction);
        }
    }

    private void createUIComponents() {
        buttonContainer = new JPanel();
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        buttonContainer.setLayout(new GridLayout(0, 1));
    }
}
