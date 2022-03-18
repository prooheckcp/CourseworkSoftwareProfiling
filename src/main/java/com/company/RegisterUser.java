package com.company;

/*
This is one of the actions present in the main menu.
It allows the user to create a new account into the system.

    Public methods:
        Main
            Description: Option that gets called upon the selection of the "Register" on the profile.

            Return:
                Boolean -> True if ready to leave this option. False if still not ready.
*/

public class RegisterUser extends MenuAction{
    RegisterUser(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        Util.print("Register:");
        Util.printInLine("Username: ");
        String insertedUsername = Util.getLine();
        Util.printInLine("Password: ");
        String insertedPassword = Util.getLine();

        Tuple<Boolean, String> creationResult = Data.createUser(insertedUsername, insertedPassword);
        if(!creationResult.getValue1()){
            Util.print(creationResult.getValue2());
            if(Util.retryPrompt())
                Main();

            return false;
        }

        Util.print("Account created!");

        //No need to check if value1 is true because we just made this user
        LoginUser.loginAttempt(Data.getUser(insertedUsername.strip()).getValue2());

        return true;
    }
}
