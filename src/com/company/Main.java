package com.company;

public class Main {

    public static void main(String[] args) {
        data.declareTestUsers();
        Util.print(data.INITIAL_MESSAGE);
        while(true) {
            InputManager.MainWindow();
        }
    }
}
