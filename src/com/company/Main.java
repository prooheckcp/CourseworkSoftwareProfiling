package com.company;

public class Main {

    public static void main(String[] args) {
        Data.declareTestUsers();
        Data.populateAuthenticationList();

        Options mainWindowOptions = new Options(new MenuAction[]{
                new RegisterUser("Register"),
                new LoginUser("Log-in")
        });

        Util.print(Data.INITIAL_MESSAGE);
        while(true) {
            mainWindowOptions.promptOptions();
        }
    }
}
