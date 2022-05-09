package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Vector;

/*
This class holds the GUI of an application. It allows you to build your own GUI
with whatever panels you want.
*/

public class GUI {

    //Constants
    Dimension MINIMUM_DIMENSION = new Dimension(500, 200);
    String APPLICATION_NAME = "University of Bradford | IT services";

    //Variables
    private JFrame applicationFrame;

    private JPanel _mainPanel;
    private JPanel _registerPanel;
    private JPanel _loginPanel;
    private JPanel _profilePanel;
    private JPanel _authenticationPanel;
    private JPanel _accountDetailsPanel;

    //Store actions
    Vector<MenuAction> mainWindowActions = new Vector<MenuAction>();
    Vector<MenuAction> profileWindowActions = new Vector<MenuAction>();
    Vector<MenuAction> authenticationWindowActions = new Vector<MenuAction>();

    //Getters
    protected JPanel getMainPanel(){
        return _mainPanel;
    };

    protected JPanel getRegisterPanel(){
        return _registerPanel;
    }

    protected JPanel getLoginPanel(){
        return _loginPanel;
    }

    protected JPanel getProfilePanel(){
        return _profilePanel;
    }

    protected JPanel getAuthenticationPanel(){
        return _authenticationPanel;
    }

    protected JPanel getAccountDetailsPanel(){
        return _accountDetailsPanel;
    }

    //Setters
    protected void setMainPanel(JPanel panel){
        _mainPanel = panel;
    }

    protected void setRegisterPanel(JPanel panel){
        _registerPanel = panel;
    }

    protected void setLoginPanel(JPanel panel){
        _loginPanel = panel;
    }

    protected void setProfilePanel(JPanel panel){
        _profilePanel = panel;
    }

    protected void setAuthenticationPanel(JPanel panel){
        _authenticationPanel = panel;
    }

    protected void setAccountDetailsPanel(JPanel panel){
        _accountDetailsPanel = panel;
    }

    //Utility methods
    protected void replacePanel(JPanel newPanel){
        if(newPanel == null)
            return;

        applicationFrame.getContentPane().removeAll(); //Clear current panel
        applicationFrame.add(newPanel);
        applicationFrame.revalidate();
        applicationFrame.repaint();
    }

    private void setupMainWindowEvents(){
        MenuAction loginAction = new MenuAction("Log-in"){
            @Override
            public void Main(){
                replacePanel(_loginPanel);
            }
        };

        MenuAction registerAction = new MenuAction("Register"){
            @Override
            public void Main(){
                replacePanel(_registerPanel);
            }
        };

        mainWindowActions.add(loginAction);
        mainWindowActions.add(registerAction);
    }

    private void setupProfileWindowActions(){
        MenuAction logoutAction = new MenuAction("Log-out"){
            @Override
            public void Main(){
                Profile.logout();
                replacePanel(_mainPanel);
            }
        };

        MenuAction changeAuthenticationAction = new MenuAction("Change Authentication Method"){
            @Override
            public void Main(){
                replacePanel(_authenticationPanel);
            }
        };

        MenuAction showAccountDetailsAction = new MenuAction("Show Account Details"){
            @Override
            public void Main(){
                replacePanel(_accountDetailsPanel);
            }
        };

        profileWindowActions.add(logoutAction);
        profileWindowActions.add(changeAuthenticationAction);
        profileWindowActions.add(showAccountDetailsAction);
    }

    private void setupAuthenticationWindowActions(){
        for (Map.Entry<AuthenticationMethod, Authentication> entry : Data.authenticationList.entrySet()) {
            AuthenticationMethod key = entry.getKey();
            String authenticationName = Data.authenticationStrings.get(key);

            MenuAction menuAction = new MenuAction(authenticationName){
                @Override
                public void Main() {
                    Profile.currentUser.setAuthenticationMethod(key);
                    replacePanel(_profilePanel);
                }
            };

            authenticationWindowActions.add(menuAction);
        }
    }
    protected void setupEvents(){
        setupMainWindowEvents();
        setupProfileWindowActions();
        setupAuthenticationWindowActions();
    }

    public void start(){
        if(_mainPanel == null){
            Util.print("Forgot to set main panel!");
            return;
        }

        applicationFrame = new JFrame();
        applicationFrame.setMinimumSize(MINIMUM_DIMENSION);
        applicationFrame.add(this._mainPanel, BorderLayout.CENTER);
        applicationFrame.setTitle(APPLICATION_NAME);
        applicationFrame.setVisible(true);
    };
}
