package com.company;

/*
Basic demo class to run the program logic
*/

public class Main {
    public static void main(String[] args) {
        Data.declareTestUsers();
        Data.populateAuthenticationList();

        Util.print(Data.INITIAL_MESSAGE);

        /*
        while(true) {
            Data.mainWindowOptions.promptOptions();
        }
        */
    }
}
