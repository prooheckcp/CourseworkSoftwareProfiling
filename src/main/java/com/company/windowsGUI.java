package com.company;

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

        //Populating the required panels for the application
        setMainPanel(mainWindow.getMainContainer());
        setProfilePanel(profileWindow.getMainContainer());
        setAuthenticationPanel(authenticationWindow.getMainContainer());

        setRegisterPanel(new WindowsRegister().getMainContainer());

        super.start();
    }
}
