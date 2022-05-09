package com.company.GUIs.Windows;

/*
This is a template for Windows options panels
*/

import com.company.MenuAction;
import com.company.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class WindowsOptions {
    private JPanel mainContainer;
    private JLabel mainTitle;
    private JPanel buttonContainer;
    private JLabel description;

    private void generateButton(MenuAction menuAction){
        JButton newButton = new JButton(menuAction.actionName);
        newButton.setSize(new Dimension(400 ,20));
        buttonContainer.add(newButton);
    }

    public JPanel getMainContainer(){
        return this.mainContainer;
    }

    String test;
    public WindowsOptions(String menuName, String descriptionMessage, Vector<MenuAction> menuActions){
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
    }
}
