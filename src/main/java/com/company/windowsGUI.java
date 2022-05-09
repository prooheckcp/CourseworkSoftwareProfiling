package com.company;

import com.company.GUIs.Windows.MainWindowWindows;

public class windowsGUI extends GUI {
    @Override
    public void start() {
        this.setMainPanel(new MainWindowWindows().MainContainer);
        super.start();
    }
}
