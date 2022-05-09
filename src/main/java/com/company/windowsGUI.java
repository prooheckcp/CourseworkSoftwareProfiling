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
                "Main Window",
                "Please select what you wish to do.",
                mainWindowActions
        );

        //Populating the required panels for the application
        setMainPanel(mainWindow.getMainContainer());
        setRegisterPanel(new WindowsRegister().getMainContainer());

        super.start();
    }
}
