package com.company.GUIcontainers;

import com.company.GUIcontainers.GUI;
import com.company.GUIs.Windows.WindowsLogin;
import com.company.GUIs.Windows.WindowsOptions;
import com.company.GUIs.Windows.WindowsRegister;

public class windowsGUI extends GUI {
    @Override
    public void start() {
        //Creates the actions of the GUI
        setupEvents();

        //Creating options panels
        WindowsOptions mainWindow = new WindowsOptions(
                "Main Hub",
                "Please select what you wish to do.",
                mainWindowActions
        );

        WindowsOptions profileWindow = new WindowsOptions(
                "Profile",
                "Welcome to your account, what do you wish to do?",
                profileWindowActions
        );

        WindowsOptions authenticationWindow = new WindowsOptions(
                "Authentication",
                "Please select your desired authentication method",
                authenticationWindowActions
        );

        //Populating the options panels
        setMainPanel(mainWindow.getMainContainer());
        setProfilePanel(profileWindow.getMainContainer());
        setAuthenticationPanel(authenticationWindow.getMainContainer());

        //Create the rest of the panels
        WindowsRegister windowsRegister = new WindowsRegister(this);
        WindowsLogin windowsLogin = new WindowsLogin(this);

        setLoginPanel(windowsLogin.getMainContainer());
        setRegisterPanel(windowsRegister.getMainContainer());

        super.start();
    }
}
