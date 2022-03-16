package com.company;

import java.util.Scanner;

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

        Tuple<Boolean, String> creationResult = data.createUser(insertedUsername, insertedPassword);
        if(!creationResult.getValue1()){
            Util.print(creationResult.getValue2());

            return Util.retryPrompt();
        }

        Util.print("Account created!");

        return true;
    }
}
