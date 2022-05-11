package com.company.GUIcontainers;

//Imports
import com.company.AccountManagers.Profile;
import com.company.Authentication.Authentication;
import com.company.Utiliity.*;
import com.company.enums.AuthenticationMethod;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Vector;

/*
This class holds the GUI of an application. It allows you to build your own GUI
with whatever panels you want.

    Private methods:
        setupMainWindowEvents
            Description:
                Setups the events related to the choices in the main window.

        setupProfileWindowActions
            Description:
                Setups the events related to the choices in profile window.

        setupAuthenticationWindowActions
            Description:
                Setups the events related to the choices in the authentication method window.

    Public methods:
        getCurrentPanel
            Returns:
                JPanel -> The current panel being used by the application

        getMainPanel
            Returns:
                JPanel -> The main panel of the application (First window)

        getRegisterPanel
            Returns:
                JPanel -> The panel on which the user can register

        getLoginPanel
            Returns:
                JPanel -> The panel used to log into a profile

        getProfilePanel
            Returns:
                JPanel -> Returns the option's panel of the user profile

        getAuthenticationPanel
            Returns:
                JPanel -> Returns the option's panel for the authentications methods of the user

        getAccountDetailsPanel
            Returns:
                JPanel -> Returns the window of details about a users account

        setMainPanel
            Description:
                Sets the main panel of the application

            Arguments:
                panel : JPanel -> Sets the panel

        setRegisterPanel
            Description:
                Sets the register panel of the application

            Arguments:
                panel : JPanel -> Sets the panel

        setLoginPanel
            Description:
                Sets the login panel of the application

            Arguments:
                panel : JPanel -> Sets the panel

        setProfilePanel
            Description:
                Sets the profile panel of the application

            Arguments:
                panel : JPanel -> Sets the panel

        setAuthenticationPanel
            Description:
                Sets the authentication panel of the application

            Arguments:
                panel : JPanel -> Sets the panel

        setAccountDetailsPanel
            Description:
                Sets the account details panel of the application

            Arguments:
                panel : JPanel -> Sets the panel

        replacePanel
            Description:
                Switches between two panels during Run-time

            Arguments:
                newPanel : JPanel -> The new panel that will be displayed

        setupEvents
            Description:
                Setups all the events related to the main, profile and authentication windows. Used to feed information to the options classes.

        goToMainWindow
            Description:
                Wrapper function to replace the current panel with the main window

        goToProfileWindow
            Description:
                Wrapper function to replace the current panel with the profile window

        loginAttempt
            Description:
                This function attempts to log into a user account with a given username and password and gives feedback via dialog box in case the login failed.

            Arguments:
                username : String -> The username of the users account
                password : String -> The password of the users account

        registerAttempt
            Description:
                This function attempts to register a user account with a given username and password and gives feedback via dialog box in case the login failed.

            Arguments:
                username : String -> The username of the users account
                password : String -> The password of the users account

        start
            Description:
                Starts the application
*/

public class GUI {

    //Constants
    static final Dimension MINIMUM_DIMENSION = new Dimension(700, 400);
    static final String APPLICATION_NAME = "University of Bradford | IT services";

    static final String LOGIN_ACTION = "Log-in";
    static final String REGISTER_ACTION = "Register";
    static final String LOGOUT_ACTION = "Log-out";
    static final String CHANGE_AUTHENTICATION_ACTION = "Change Authentication Method";
    static final String SHOW_DETAILS_ACTION = "Show Account Details";

    //Variables
    private JFrame applicationFrame;

    private JPanel _currentPanel;
    private JPanel _mainPanel;
    private JPanel _registerPanel;
    private JPanel _loginPanel;
    private JPanel _profilePanel;
    private JPanel _authenticationPanel;
    private JPanel _accountDetailsPanel;

    //Store actions
    public Vector<MenuAction> mainWindowActions = new Vector<MenuAction>();
    public Vector<MenuAction> profileWindowActions = new Vector<MenuAction>();
    public Vector<MenuAction> authenticationWindowActions = new Vector<MenuAction>();

    //Getters
    public JPanel getCurrentPanel(){return _currentPanel;}

    public JPanel getMainPanel(){
        return _mainPanel;
    };

    public JPanel getRegisterPanel(){
        return _registerPanel;
    }

    public JPanel getLoginPanel(){
        return _loginPanel;
    }

    public JPanel getProfilePanel(){
        return _profilePanel;
    }

    public JPanel getAuthenticationPanel(){
        return _authenticationPanel;
    }

    public JPanel getAccountDetailsPanel(){
        return _accountDetailsPanel;
    }

    //Setters
    public void setMainPanel(JPanel panel){
        _mainPanel = panel;
    }

    public void setRegisterPanel(JPanel panel){
        _registerPanel = panel;
    }

    public void setLoginPanel(JPanel panel){
        _loginPanel = panel;
    }

    public void setProfilePanel(JPanel panel){
        _profilePanel = panel;
    }

    public void setAuthenticationPanel(JPanel panel){
        _authenticationPanel = panel;
    }

    public void setAccountDetailsPanel(JPanel panel){
        _accountDetailsPanel = panel;
    }

    //Utility methods
    protected void replacePanel(JPanel newPanel){
        if(newPanel == null)
            return;

        _currentPanel = newPanel;
        applicationFrame.getContentPane().removeAll(); //Clear current panel
        applicationFrame.add(newPanel);
        applicationFrame.revalidate();
        applicationFrame.repaint();
    }

    private void setupMainWindowEvents(){
        MenuAction loginAction = new MenuAction(LOGIN_ACTION){
            @Override
            public void Main(){
                replacePanel(_loginPanel);
            }
        };

        MenuAction registerAction = new MenuAction(REGISTER_ACTION){
            @Override
            public void Main(){
                replacePanel(_registerPanel);
            }
        };

        mainWindowActions.add(loginAction);
        mainWindowActions.add(registerAction);
    }

    private void setupProfileWindowActions(){
        MenuAction logoutAction = new MenuAction(LOGOUT_ACTION){
            @Override
            public void Main(){
                Profile.logout();
                replacePanel(_mainPanel);
            }
        };

        MenuAction changeAuthenticationAction = new MenuAction(CHANGE_AUTHENTICATION_ACTION){
            @Override
            public void Main(){
                replacePanel(_authenticationPanel);
            }
        };

        MenuAction showAccountDetailsAction = new MenuAction(SHOW_DETAILS_ACTION){
            @Override
            public void Main(){
                EventManager.fireEvent(Data.PROFILE_UPDATE);
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
                    Profile.getCurrentUser().setAuthenticationMethod(key);
                    replacePanel(_profilePanel);
                }
            };

            authenticationWindowActions.add(menuAction);
        }
    }

    public void goToMainWindow(){
        replacePanel(_mainPanel);
    }

    public void goToProfileWindow(){
        replacePanel(_profilePanel);
    }

    public void loginAttempt(String username, String password){
        Tuple<Boolean, String> loginAttemptResponse = Profile.loginAttempt(username, password);
        Boolean success = loginAttemptResponse.getValue1();
        String errorMessage = loginAttemptResponse.getValue2();

        if(!success){
            Util.warning(errorMessage);
            return;
        }

        EventManager.fireEvent(Data.LOGGED_IN);

        replacePanel(_profilePanel);
    }

    public void registerAttempt(String username, String password){
        Tuple<Boolean, String> registerAttemptResponse = Profile.registerAttempt(username, password);
        Boolean success = registerAttemptResponse.getValue1();
        String errorMessage = registerAttemptResponse.getValue2();

        if(!success){
            Util.warning(errorMessage);
            return;
        }

        EventManager.fireEvent(Data.LOGGED_IN);

        replacePanel(_profilePanel);
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

        _currentPanel = _mainPanel;
        applicationFrame = new JFrame();
        applicationFrame.setMinimumSize(MINIMUM_DIMENSION);
        applicationFrame.add(this._mainPanel, BorderLayout.CENTER);
        applicationFrame.setTitle(APPLICATION_NAME);
        applicationFrame.setVisible(true);
    };
}
