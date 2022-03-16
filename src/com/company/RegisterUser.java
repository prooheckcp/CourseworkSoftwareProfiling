package com.company;

import java.util.Scanner;

public class RegisterUser extends MenuAction{
    RegisterUser(String actionName){
        super(actionName);
    }

    public Boolean Main(){
        Util.print("");
        Util.print("Register menu:");
        Util.printInLine("username: ");
        String insertedUsername = Util.getLine();
        Util.printInLine("password: ");
        String insertedPassword = Util.getLine();

        Tuple<Boolean, String> creationResult = data.createUser(insertedUsername, insertedPassword);
        if(!creationResult.getValue1()){
            Util.print(creationResult.getValue2());

            Util.print("Press 1 to retry or any other key to go back");
            return (InputManager.parseOption(Util.getLine()) != 1);
        }

        Util.print("Account created!");

        return true;
    }
}
