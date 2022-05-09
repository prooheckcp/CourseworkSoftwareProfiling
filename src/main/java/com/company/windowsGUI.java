package com.company;

import com.company.GUIs.Windows.WindowsOptions;

public class windowsGUI extends GUI {
    @Override
    public void start() {
        //Creating options panels
        WindowsOptions mainWindow = new WindowsOptions(
                "Main Window",
                "Please select what you wish to do.",
                Data.mainWindowActions
        );

        //Populating the required panels for the application
        setMainPanel(mainWindow.getMainContainer());


        super.start();
    }
}
