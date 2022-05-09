package com.company;

/*
Basic demo class to run the program logic
*/

import com.company.Utiliity.Data;
import com.company.Utiliity.Util;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Data.GUIList.get(Data.currentOperatingSystem).start();
    }
}
