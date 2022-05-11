package com.company.GUIs.Windows;

//Imports
import com.company.Utiliity.MenuAction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/*
This is a template for Windows options panels
    Private methods:
        generateButton
            Description:
                Creates a new button inside of the button container panel

            Arguments:
                menuAction : MenuAction -> The callback that will be called when the button is pressed

        createUIComponents
            Description:
                Default function from the Swinger library. It's used to manage custom created components by code

    Public methods:
        setDescription
            Description:
                Updates the description of the options window. Useful to change the text in run-time context.

            Arguments:
                newDescription : String -> The new description to be displayed in the label

        getMainContainer
            Description:
                Returns the main panel container of this Window

            Returns:
                JPanel -> The main container
*/
public class WindowsOptions {
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

    public WindowsOptions(String menuName, String descriptionMessage, Vector<MenuAction> menuActions){
        mainTitle.setText(menuName);
        description.setText(descriptionMessage);
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
