package com.company;

/*
Basic demo class to run the program logic
*/

import com.company.Utility.Data;

public class Main {
    public static void main(String[] args) {
        //Start the program with a given operating system
        Data.GUIList.get(Data.currentOperatingSystem).start();
    }
}
